import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CadastroPrepared extends
 JFrame implements ActionListener {

	JLabel lblCodigo, lblNome, lblEmail, lblTelefone, lblEndereco;
	JTextField txtCodigo, txtNome, txtEmail, txtTelefone, txtEndereco;
	JPanel painel2, painel3;
	JButton btSalvar, btPesquisar, btLimpar, btSair, btExcluir;
	static CadastroPrepared t01;
	
	private static Connection conn = null; 
	private static Statement comandoSQL;
	Conexao conexao = new Conexao();
	CadastroPrepared(){
				
		this.setTitle("Cadastro Usu�rios");
		this.setSize(500, 200);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(5,10));
		
		btPesquisar = new JButton("Pesquisar");
		btLimpar = new JButton("Limpar"); 
		btSalvar = new JButton("Salvar");
		btExcluir = new JButton("Excluir");		
		btSair  = new JButton("Sair");

		painel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painel2.add(btPesquisar);
		painel2.add(btLimpar);
		painel2.add(btSalvar);
		painel2.add(btExcluir);
		painel2.add(btSair);
		
		painel3 = new JPanel(new GridLayout(5,2,10,5));

		lblCodigo = new JLabel("C�digo");
		lblNome = new JLabel("Nome");
		lblEmail = new JLabel("Email");
		lblTelefone = new JLabel("Telefone");
		lblEndereco = new JLabel("Endere�o");
		
		txtCodigo = new JTextField();
		txtNome = new JTextField();
		txtEmail = new JTextField();
		txtTelefone = new JTextField();
		txtEndereco = new JTextField();
		
		painel3.add(lblCodigo);
		painel3.add(txtCodigo);
		
		painel3.add(lblNome);
		painel3.add(txtNome);

		painel3.add(lblEmail);
		painel3.add(txtEmail);

		painel3.add(lblTelefone);
		painel3.add(txtTelefone);

		painel3.add(lblEndereco);
		painel3.add(txtEndereco);
		painel3.setBackground(Color.WHITE);

		btSalvar.addActionListener(this);
		btLimpar.addActionListener(this);
		btPesquisar.addActionListener(this);
		btExcluir.addActionListener(this);
		
		btSair.addActionListener(this);
		
		this.add(painel2, BorderLayout.SOUTH);
		this.add(painel3, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		t01 = new CadastroPrepared();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSair) {
			System.exit(0);
		} if (e.getSource() == btPesquisar) {
			if (!(txtCodigo.getText().isEmpty())) {
				pesquisar(txtCodigo.getText(),"IdUsuario",true);
			} else if (!(txtNome.getText().isEmpty())){
				pesquisar(txtNome.getText(),"nome",true);				
			} else if (!(txtEmail.getText().isEmpty())){
				pesquisar(txtEmail.getText(),"email",true);								
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, \nDigite o C�digo, Nome ou o Email !!!");
			}
		} else if (e.getSource() == btLimpar) {
			this.limpar();	
		} else if (e.getSource() == btExcluir) {
			this.excluir();
		} else if (e.getSource() == btSalvar) {
			this.salvar();
		}
	}

	public boolean pesquisar(String texto, String campo, boolean atualizaTela){
		String sql;
		boolean flagEncontrado=false;
		conn = conexao.conectar();
		PreparedStatement st;
		try {
			if (campo=="IdUsuario") {
				sql = "Select * From Usuario Where "+campo+" = ?";	
				st = conn.prepareStatement(sql);
				st.setInt(1, Integer.parseInt(texto));
				
			} else {
				sql = "Select * From Usuario Where "+campo+" like ?";
				st = conn.prepareStatement(sql);
				st.setString(1, texto+"%");				
			}
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()){
				if (atualizaTela) {
					txtCodigo.setText(String.valueOf(
					rs.getInt("IdUsuario")));
					txtNome.setText(rs.getString("nome"));
					txtEmail.setText(rs.getString("email"));
					txtTelefone.setText(rs.getString("telefone"));
					txtEndereco.setText(rs.getString("endereco"));
				}
				flagEncontrado = true;
			} else if (atualizaTela) {
				JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado !!!");
			}
			
			conexao.fecharConexao(conn);
			
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL+"\n"+e);
		}
		return flagEncontrado;
	}
	
	public void limpar(){
		txtCodigo.setText(null);
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtEndereco.setText(null);
	}
	
	public void salvar(){
		String sql;
		String operacao;
		PreparedStatement st;
		
		
		try {

			if (this.pesquisar(txtCodigo.getText(), "IdUsuario", false)) {
				sql = " Update Usuario";
				sql+= " Set";
				sql+= " nome = ?";
				sql+= ",email = ?";
				sql+= ",telefone = ?";
				sql+= ",endereco = ?";
				sql+= " Where IdUsuario= ?";
				operacao="Altera��o";
				
				conn = conexao.conectar();
				st = conn.prepareStatement(sql);
				st.setString(1, txtNome.getText());
				st.setString(2, txtEmail.getText());
				st.setString(3, txtTelefone.getText());
				st.setString(4, txtEndereco.getText());
				st.setInt(5, 
					Integer.parseInt(txtCodigo.getText()
				));
				st.executeUpdate();
		
			} else
			{
				sql = " Insert Into Usuario Values ( ?, ?, ?, ?, ?)";
				operacao="Inclus�o";			
				
				conn = conexao.conectar();
				st = conn.prepareStatement(sql);
				st.setInt(1, 
				Integer.parseInt(txtCodigo.getText()));
				st.setString(2, txtNome.getText());
				st.setString(3, txtEmail.getText());
				st.setString(4, txtTelefone.getText());
				st.setString(5, txtEndereco.getText());
				st.executeUpdate();
			}
			
			System.out.println(sql);

			JOptionPane.showMessageDialog(null,operacao+" realizada com sucesso.");
					
			conexao.fecharConexao(conn);
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL+"\n"+e);
		}

	}

	public void excluir(){
		String sql="";
		PreparedStatement st;
		
		
		try {

			int resp =JOptionPane.showConfirmDialog(null, "Confirma a Exclus�o ?", "Exclus�o", JOptionPane.YES_NO_OPTION);
			
			if (resp == JOptionPane.YES_OPTION){
				if (this.pesquisar(txtCodigo.getText(), "IdUsuario", true)) {
					sql = "Delete From Usuario Where IdUsuario = ?";	
					
					conn = conexao.conectar();
					st = conn.prepareStatement(sql);
					st.setInt(1, 
					Integer.parseInt(txtCodigo.getText()));
					
					st.executeUpdate();
					
					System.out.println(sql);			
					JOptionPane.showMessageDialog(null,"Exclus�o realizada com sucesso.");
					this.limpar();
					conexao.fecharConexao(conn);
				} 
			}	
			
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL+"\n"+e);
		}

	}

	
	
}

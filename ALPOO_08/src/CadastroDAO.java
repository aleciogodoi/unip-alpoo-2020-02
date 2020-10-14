import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CadastroDAO extends JFrame implements ActionListener {

	JLabel lblCodigo, lblNome, lblEmail, lblTelefone, lblEndereco;
	JTextField txtCodigo, txtNome, txtEmail, txtTelefone, txtEndereco;
	JPanel painel2, painel3;
	JButton btSalvar, btPesquisar, btLimpar, btSair, btTodos, btTotal, btExcluir;
	static CadastroDAO t01;
	
	CadastroDAO(){
				
		this.setTitle("Cadastro Usuários");
		this.setSize(550, 200);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(5,10));
		
		btPesquisar = new JButton("Pesquisar");
		btTodos = new JButton("Todos");
		btTotal = new JButton("Total");
		btLimpar = new JButton("Limpar"); 
		btSalvar = new JButton("Salvar");
		btExcluir = new JButton("Excluir");		
		btSair  = new JButton("Sair");

		painel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painel2.add(btPesquisar);
		painel2.add(btTodos);
		painel2.add(btTotal);
		painel2.add(btLimpar);
		painel2.add(btSalvar);
		painel2.add(btExcluir);
		painel2.add(btSair);
		
		painel3 = new JPanel(new GridLayout(5,2,10,5));

		lblCodigo = new JLabel("Código");
		lblNome = new JLabel("Nome");
		lblEmail = new JLabel("Email");
		lblTelefone = new JLabel("Telefone");
		lblEndereco = new JLabel("Endereço");
		
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
		btTodos.addActionListener(this);
		btTotal.addActionListener(this);
		btLimpar.addActionListener(this);
		btPesquisar.addActionListener(this);
		btExcluir.addActionListener(this);
		
		btSair.addActionListener(this);
		
		this.add(painel2, BorderLayout.SOUTH);
		this.add(painel3, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		t01 = new CadastroDAO();
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
				JOptionPane.showMessageDialog(null, "Por favor, \nDigite o Código, Nome ou o Email !!!");
			}
		} else if (e.getSource() == btLimpar) {
			this.limpar();	
		} else if (e.getSource() == btExcluir) {
			int id = Integer.valueOf(txtCodigo.getText());
			this.excluir(id);
		} else if (e.getSource() == btSalvar) {
			this.salvar();
		} else if (e.getSource() == btTodos) {
			this.todosUsuarios();
		} else if (e.getSource() == btTotal) {
			this.totalUsuarios();
		} 
	}

	public void totalUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		JOptionPane.showMessageDialog(this,"Total de Usuários: "+ usuarioDAO.selectCount());
	}
	
	public void todosUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		String usuarios = "";
		
		for (Usuario usuario : usuarioDAO.getUsuarios()) {
			usuarios += usuario.toString()+"\n";
		}
		
		JOptionPane.showMessageDialog(this, usuarios);
	}
	
	public boolean pesquisar(String texto, String campo, boolean atualizaTela){
		boolean flagEncontrado=false;
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (campo.equals("IdUsuario")) {
			usuario = usuarioDAO.select(Integer.parseInt(texto));    // Consultar usuário pelo Id
		} else  {
			usuario = usuarioDAO.select(campo, texto);    // Consultar usuário pelo Nome/Email		
		} 
	
		System.out.println(usuario);
		if (!(usuario == null)){
			if (atualizaTela) {
				txtCodigo.setText(String.valueOf(usuario.getIdUsuario()));
				txtNome.setText(usuario.getNome());
				txtEmail.setText(usuario.getEmail());
				txtTelefone.setText(usuario.getTelefone());
				txtEndereco.setText(usuario.getEndereco());
			}
			flagEncontrado = true;
		} else if (atualizaTela) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado !!!");
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
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();		
		
		if (this.pesquisar(txtCodigo.getText(), "IdUsuario", false)) {
			usuario.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
			usuario.setNome(txtNome.getText());
			usuario.setEmail(txtEmail.getText());
			usuario.setTelefone(txtTelefone.getText());
			usuario.setEndereco(txtEndereco.getText());			
			usuarioDAO.update(usuario);;    // Atualizar usuário
		} else
		{
			usuario.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
			usuario.setNome(txtNome.getText());
			usuario.setEmail(txtEmail.getText());
			usuario.setTelefone(txtTelefone.getText());
			usuario.setEndereco(txtEndereco.getText());
			usuarioDAO.insert(usuario);   // Incluir usuário
		}
	}

	public void excluir(int id){	
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		int resp =JOptionPane.showConfirmDialog(null, "Confirma a Exclusão ?", "Exclusão", JOptionPane.YES_NO_OPTION);	
		if (resp == JOptionPane.YES_OPTION){
			if (this.pesquisar(txtCodigo.getText(), "IdUsuario", true)) {
				usuarioDAO.delete(id);;  // Excluir Usuário
				this.limpar();
			} 
		}	
	}
}

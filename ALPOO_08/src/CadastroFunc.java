import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

import javax.sql.StatementEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class CadastroFunc {

	/**
	 * Tela
	 */
	private JFrame frame;

	/**
	 * Componentes da tela
	 */
	private JTextField txtNome;
	private JTextField txtRG;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTitulo;
	private JComboBox cbProfissao;
	private JLabel lblNome;
	private JLabel lblRg;
	private JLabel lblSexo;
	private JRadioButton rbMasc;
	private JRadioButton rbFemin;
	private JLabel lblProfissao;
	private JLabel lblBenef;
	private JCheckBox cbVT;
	private JCheckBox cbVA;
	private JCheckBox cbSalarioFamilia;
	private JCheckBox cbProd;
	private JButton btnPesquisar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnSair;

	/**
	 * Conex�o
	 */
	private Conexao conexao = new Conexao();
	private Connection conn;

	/**
	 * Select das Profiss�es
	 */
	String selectProfissao = "Select idProfissao, nome From Profissao Order by nome";

	/**
	 * Select Funcion�rio
	 */
	String selectFuncionario = "Select " + "   f.idFuncionario " + "  ,f.nome " + "  ,f.RG " + "  ,f.sexo "
			+ "  ,f.idProfissao " + "  ,p.nome as Profissao" + "  ,f.valeTransporte " + "  ,f.valeAlimentacao "
			+ "  ,f.salarioFamilia " + "  ,f.produtividade " + "From Funcionario f "
			+ "Inner Join Profissao p On (p.idProfissao=f.idProfissao) " + "Where f.RG = ";

	/**
	 * Delete Funcion�rio
	 */
	String deleteFuncionario = "Delete From Funcionario Where RG = ";
	
	/**
	 * Insert Funcion�rio
	 */
	String insertFuncionario = "Insert Into Funcionario "
							 + "Values "
							 + "(  nome, rg, sexo, idProfissao"
							 + " , valeTransporte, valeAlimentacao"
							 + " , salarioFamila, produtividade"
							 + ")";

	/**
	 * Comando SQL e ResultSet
	 */
	Statement comandoSQL;
	ResultSet rs;

	/**
	 * Mapa Hash para Profiss�es link para refer�ncia:
	 * https://www.w3schools.com/java/java_hashmap.asp
	 */
	private HashMap<String, Integer> profissoes = null;
	Object[] listaProfissao;

	/**
	 * main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFunc window = new CadastroFunc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria aplica��o e carrega combo das Profiss�es
	 */
	public CadastroFunc() {
		carregaProfissoes();
		initialize();
	}

	public void carregaProfissoes() {
		profissoes = new HashMap<String, Integer>();
		try {
			conn = conexao.conectar();
			comandoSQL = conn.createStatement();
			rs = comandoSQL.executeQuery(selectProfissao);
			while (rs.next()) {
				profissoes.put(rs.getString("nome"), rs.getInt("idProfissao"));
			}
			listaProfissao = profissoes.keySet().toArray();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL + "\n" + e);
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	/**
	 * Inicializa��o/montagem da Tela
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cadastro Funcion�rio");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 440, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		lblTitulo = new JLabel("Cadastro Funcion�rio");
		lblTitulo.setBounds(126, 10, 200, 14);
		frame.getContentPane().add(lblTitulo);

		lblRg = new JLabel("R.G.:");
		lblRg.setBounds(10, 38, 46, 14);
		frame.getContentPane().add(lblRg);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 63, 46, 14);
		frame.getContentPane().add(lblNome);

		txtRG = new JTextField();
		txtRG.setBounds(89, 35, 235, 20);
		frame.getContentPane().add(txtRG);
		txtRG.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(89, 60, 235, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblSexo);

		rbMasc = new JRadioButton("Masculino");
		buttonGroup.add(rbMasc);
		rbMasc.setBackground(Color.LIGHT_GRAY);
		rbMasc.setBounds(89, 91, 97, 23);
		frame.getContentPane().add(rbMasc);

		rbFemin = new JRadioButton("Feminino ");
		buttonGroup.add(rbFemin);
		rbFemin.setBackground(Color.LIGHT_GRAY);
		rbFemin.setBounds(236, 91, 88, 23);
		frame.getContentPane().add(rbFemin);

		lblProfissao = new JLabel("Profiss�o:");
		lblProfissao.setBounds(10, 128, 71, 14);
		frame.getContentPane().add(lblProfissao);

		cbProfissao = new JComboBox(listaProfissao);
		cbProfissao.setBounds(89, 125, 198, 20);
		frame.getContentPane().add(cbProfissao);

		lblBenef = new JLabel("Beneficios:");
		lblBenef.setBounds(10, 162, 71, 14);
		frame.getContentPane().add(lblBenef);

		cbVT = new JCheckBox("V Transporte");
		cbVT.setBackground(Color.LIGHT_GRAY);
		cbVT.setBounds(76, 158, 125, 23);
		frame.getContentPane().add(cbVT);

		cbVA = new JCheckBox("V Alimenta��o ");
		cbVA.setBackground(Color.LIGHT_GRAY);
		cbVA.setBounds(205, 158, 123, 23);
		frame.getContentPane().add(cbVA);

		cbSalarioFamilia = new JCheckBox("Sal�rio Familia");
		cbSalarioFamilia.setBackground(Color.LIGHT_GRAY);
		cbSalarioFamilia.setBounds(76, 184, 125, 23);
		frame.getContentPane().add(cbSalarioFamilia);

		cbProd = new JCheckBox("Produtividade ");
		cbProd.setBackground(Color.LIGHT_GRAY);
		cbProd.setBounds(205, 184, 123, 23);
		frame.getContentPane().add(cbProd);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisar(true);
			}
		});
		btnPesquisar.setBounds(10, 227, 95, 23);
		frame.getContentPane().add(btnPesquisar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaTela();
			}
		});
		btnLimpar.setBounds(110, 227, 80, 23);
		frame.getContentPane().add(btnLimpar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluir();
			}
		});
		btnExcluir.setBounds(195, 227, 80, 23);
		frame.getContentPane().add(btnExcluir);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setBounds(280, 227, 80, 23);
		frame.getContentPane().add(btnSalvar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(365, 227, 60, 23);
		frame.getContentPane().add(btnSair);

	}

	/**
	 * Salvar
	 */
	public void salvar() {
		String sql = "";
		if (pesquisar(false)) {		
		} else {
	   		conn = conexao.conectar();
	   		sql = insertFuncionario 
	   				+ "'"+txtNome.getText()+"'"
	   		   		+ "'"+txtRG.getText()+"'"
	   		 	   	+ "'"+rbFemin+"'"
	   		 		+ "'"+txtNome.getText()+"'"
	   		 		+ "'"+txtNome.getText()+"'"
	   				;
		}
   	
   		try {
   			comandoSQL = conn.createStatement();
   			comandoSQL.executeUpdate(sql);
   			limpaTela();
   		}
	   	catch (SQLException e){
				JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL+"\n"+e);
		} finally {
	    		conexao.fecharConexao(conn);
		}
	}

	/**
     * Excluir
     */
    public void excluir() {
    	if (txtRG.getText().isEmpty() || txtRG.getText().isBlank()) {
    		JOptionPane.showMessageDialog(null, "RG deve ser informado!!!");
    	} else {
    		if (JOptionPane.showConfirmDialog(
    				null, "Confirma Exclus�o", "Exclus�o", 
    				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {			
		   		conn = conexao.conectar();
		   		String sql = deleteFuncionario +"'"+txtRG.getText()+"'";
		   		try {
		   			comandoSQL = conn.createStatement();
		   			comandoSQL.executeUpdate(sql);
		   			limpaTela();
		   		}
			   	catch (SQLException e){
						JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL+"\n"+e);
				} finally {
			    		conexao.fecharConexao(conn);
				}
    		}
    	}
    }

	/**
	 * Limpa Tela
	 */
	public void limpaTela() {
		txtNome.setText(null);
		txtRG.setText(null);
		rbMasc.setSelected(false);
		rbFemin.setSelected(false);
		cbVT.setSelected(false);
		cbVA.setSelected(false);
		cbSalarioFamilia.setSelected(false);
		cbProd.setSelected(false);
	}

	/**
	 * Pesquisar funcion�rio pelo RG
	 */
	public boolean pesquisar(boolean atualizaTela) {
		boolean encontrado = false;
		try {
			String sqlAux = selectFuncionario + "'" + txtRG.getText() + "'";
			System.out.println(sqlAux);
			conn = conexao.conectar();
			comandoSQL = conn.createStatement();
			rs = comandoSQL.executeQuery(sqlAux);

			if (rs.next()) {
				encontrado = true;
				if (atualizaTela) {
					limpaTela();
					txtNome.setText(rs.getString("nome"));
					txtRG.setText(rs.getString("RG"));
					cbProfissao.setSelectedItem((rs.getString("Profissao")));
	
					if (rs.getString("sexo").contains("F")) {
						rbFemin.setSelected(true);
					} else {
						rbMasc.setSelected(true);
					}
	
					if (rs.getInt("valeTransporte") == 1) {
						cbVT.setSelected(true);
					}
					if (rs.getInt("valeAlimentacao") == 1) {
						cbVA.setSelected(true);
					}
					if (rs.getInt("salarioFamilia") == 1) {
						cbSalarioFamilia.setSelected(true);
					}
					if (rs.getInt("produtividade") == 1) {
						cbProd.setSelected(true);
					}
				}
			} else {
				if (atualizaTela)
					System.out.println("N�o Encontrado!!!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de execu��o comando \n" + comandoSQL + "\n" + e);
		} finally {
			conexao.fecharConexao(conn);
		}
		return encontrado;
	}

}
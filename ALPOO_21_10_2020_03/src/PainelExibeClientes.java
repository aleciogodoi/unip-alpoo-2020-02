import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
public class PainelExibeClientes extends JPanel {
	//Atributos da classe.
	private JTable tabela;
	private ModeloDeTabela modelo;
	private JButton botaoatualiza;
	//Construtor
	public PainelExibeClientes(){
		//Seleciona gerenciador de leiaute.
		BorderLayout borderlayout = new BorderLayout();
		this.setLayout(borderlayout);
		//Requisitos da consulta.
		String consulta = null;
		consulta = "Select "
				+ "IdUsuario As 'Id. Usuário', "
				+ "Nome, "
				+ "Email, "
				+ "Telefone, "
				+ "Endereco as 'Endereço' "
				+ "From "
				+ "Usuario ORDER BY Nome";	
		//Cria um objeto modelo de dados.
		modelo = new ModeloDeTabela(consulta);
		//E utiliza este modelo para criar um JTable.
		
		tabela = new JTable(modelo);
		
		String[] colunas = modelo.getColumns();
		for (int i=0; i<colunas.length; i++) {
			tabela.getColumnModel().getColumn(i).setHeaderValue(colunas[i]);			
		}

		//Cria e insere um painel rolante ao painel.
		JScrollPane sp = new JScrollPane(tabela);
		this.add(sp, BorderLayout.CENTER);
		//Cria e insere um botao ao painel.
		botaoatualiza = new JButton("Atualizar");
		botaoatualiza.setSize(5, 2);
		this.add(botaoatualiza, BorderLayout.SOUTH);
		//Instancia o observador deste painel.
		ObservadorDoPainelExibeClientes odpec = new ObservadorDoPainelExibeClientes(this);
		//Gera evento para atualizacao dos dados da tabela.
		botaoatualiza.addActionListener(odpec);
	}
	//Método para carregar a tabela Clientes.
	public void carregarClientes(){
		modelo.carregaDados();
	}
}
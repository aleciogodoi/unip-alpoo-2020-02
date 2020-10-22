import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

//
//DefaultTableModel
public class ModeloDeTabela extends AbstractTableModel {
	//Atributos da classe ModeloDeTabela.
	private ArrayList<Object[]> linhas;
	private String[] colunas;
	private Statement comando;
	private String consulta;
	//Construtor da classe.
	public ModeloDeTabela(String consulta){
		try{
			//Tenta efetuar uma conex�o ao banco de dados.
			comando = ConectaBD.getInstancia().getConexao().createStatement();
			//Se a conex�o teve �xito, leia a consulta SQL desejada.
			this.consulta = consulta;
			//Instancia o atributo linhas, que receber� um array de objetos
			//que � o resultado obtido na consulta SQL enviada ao banco.
			linhas = new ArrayList<Object[]>();
			//Chama o m�todo carregaDados, respons�vel pela estrutura��o dos
			//dados obtidos na consulta SQL enviada ao banco de dados.
			carregaDados();
			//Se houve algum problema na conex�o ao banco de dados, exibe erro.
		}catch(Exception e){
			System.out.println("Modelo de Dados["+e.toString()+"]");
		}
	}
	//M�todo que far� o carregamento dos dados.
	public void carregaDados(){
		System.out.println("Modelo de Dados[carregaDados()]");
		try{
			//Tenta ler a massa de dados obtida apos a execu��o
			//da consulta SQL ao banco de dados.
			ResultSet resultado = comando.executeQuery(consulta);
			//Obt�m o n�mero, tipo e propriedades da massa de dados.
			ResultSetMetaData rsmd = resultado.getMetaData();
			//Obt�m a quantidade de colunas da massa de dados.
			int numeroDeColunas = rsmd.getColumnCount();
			//Instancia o atributo colunas.
			colunas = new String[numeroDeColunas];
			//Para a quantidade de colunas obtida na massa de dados,
			//obtenha o nome de cada coluna.
			for(int i=0; i<numeroDeColunas; i++) {
				colunas[i] = rsmd.getColumnLabel(i+1);

			}
			//Apague o conte�do do atributo linhas, haja algo ou n�o.
			linhas.clear();
			//Enquanto houver linhas n�o lidas na massa de dados...
			while(resultado.next()){
				//...crie um objeto linha, do tipo array, com a mesma
				//quantidade de colunas obtida na massa de dados.
				Object linha[] = new Object[numeroDeColunas];
				//Para cada coluna lida...
				for(int i=0; i<numeroDeColunas; i++)
					//...armazene o seu conte�do na posi��o i da linha.
					linha[i] = resultado.getObject(i+1);
				//E adicione essa linha ao atributo privado linhas,
				//que � quem armazena todas as linhas obtidas, ou seja,
				//toda a massa de dados da consulta.
				linhas.add(linha);
			}
			//Encerra a leitura da massa de dados.
			resultado.close();
			//Atualiza os dados exibidos na JTable
			fireTableDataChanged();
			//Se houve algum problema na leitura dos dados, exibe erro.
		}catch(Exception e){
			System.out.println("Modelo de Dados["+e.toString()+"]");
		}
	}
	//M�todos de implementa��o obrigat�ria
	//da interface AbstractTableModel:
	//Obt�m a quantidade de colunas.
	public int getColumnCount(){
		return colunas.length;
	}
	//Retorna os nomes das colunas 
	public String[] getColumns() {
		return colunas;
	}
	//Obt�m a quantidade de linhas.
	public int getRowCount(){
		return linhas.size();
	}
	//Obt�m o conte�do de uma c�lula (coluna x linha).
	public Object getValueAt(int linha, int coluna){
		try{
			Object celula[] = linhas.get(linha);
			return celula[coluna];
		}catch(Exception e){
			System.out.println("Modelo de Dados["+e.toString()+"]");
		}
		return null;
	}
}
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
			//Tenta efetuar uma conexão ao banco de dados.
			comando = ConectaBD.getInstancia().getConexao().createStatement();
			//Se a conexão teve êxito, leia a consulta SQL desejada.
			this.consulta = consulta;
			//Instancia o atributo linhas, que receberá um array de objetos
			//que é o resultado obtido na consulta SQL enviada ao banco.
			linhas = new ArrayList<Object[]>();
			//Chama o método carregaDados, responsável pela estruturação dos
			//dados obtidos na consulta SQL enviada ao banco de dados.
			carregaDados();
			//Se houve algum problema na conexão ao banco de dados, exibe erro.
		}catch(Exception e){
			System.out.println("Modelo de Dados["+e.toString()+"]");
		}
	}
	//Método que fará o carregamento dos dados.
	public void carregaDados(){
		System.out.println("Modelo de Dados[carregaDados()]");
		try{
			//Tenta ler a massa de dados obtida apos a execução
			//da consulta SQL ao banco de dados.
			ResultSet resultado = comando.executeQuery(consulta);
			//Obtém o número, tipo e propriedades da massa de dados.
			ResultSetMetaData rsmd = resultado.getMetaData();
			//Obtém a quantidade de colunas da massa de dados.
			int numeroDeColunas = rsmd.getColumnCount();
			//Instancia o atributo colunas.
			colunas = new String[numeroDeColunas];
			//Para a quantidade de colunas obtida na massa de dados,
			//obtenha o nome de cada coluna.
			for(int i=0; i<numeroDeColunas; i++) {
				colunas[i] = rsmd.getColumnLabel(i+1);

			}
			//Apague o conteúdo do atributo linhas, haja algo ou não.
			linhas.clear();
			//Enquanto houver linhas não lidas na massa de dados...
			while(resultado.next()){
				//...crie um objeto linha, do tipo array, com a mesma
				//quantidade de colunas obtida na massa de dados.
				Object linha[] = new Object[numeroDeColunas];
				//Para cada coluna lida...
				for(int i=0; i<numeroDeColunas; i++)
					//...armazene o seu conteúdo na posição i da linha.
					linha[i] = resultado.getObject(i+1);
				//E adicione essa linha ao atributo privado linhas,
				//que é quem armazena todas as linhas obtidas, ou seja,
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
	//Métodos de implementação obrigatória
	//da interface AbstractTableModel:
	//Obtém a quantidade de colunas.
	public int getColumnCount(){
		return colunas.length;
	}
	//Retorna os nomes das colunas 
	public String[] getColumns() {
		return colunas;
	}
	//Obtém a quantidade de linhas.
	public int getRowCount(){
		return linhas.size();
	}
	//Obtém o conteúdo de uma célula (coluna x linha).
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
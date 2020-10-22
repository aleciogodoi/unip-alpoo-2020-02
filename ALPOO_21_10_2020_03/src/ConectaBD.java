import java.sql.*;
public class ConectaBD {
	//Vari�vel est�tica que guardar� a inst�ncia da classe ConectaBD.
	private static ConectaBD instancia = null;
	//Variavel para conexao � base de dados.
	private Connection conexao = null;
	//Vari�vel para determina��o da quantidade de clientes conectados � base.
	private int quantidadeDeConexoes = 0;
	//Construtor privado
	private ConectaBD(){
		try{
			//Propriedades da conex�o � base de dados:
			//Especifica o driver JDBC utilizado.
			String bdDriver = "com.mysql.cj.jdbc.Driver";
			//Cria a url de acesso ao banco MySQL fornecendo:
			//o driver jdbc, o nome banco, o endere�o (localhost
			//neste caso) com a porta de acesso e a base de
			//dados criada na aula passada.			
			String bdUrl = "jdbc:mysql://localhost:3306/alpoo?useTimezone=true&serverTimezone=UTC";
			//Define o usu�rio de acesso ao banco de dados.
			String bdUsuario = "ale";
			//Define a senha de acesso ao banco de dados.
			String bdSenha = "ale";
			//Carregamento din�mico do driver por meio do m�todo
			//forName(String) da classe Class.
			Class.forName(bdDriver);
			//Acesso � base de dados com usu�rio e senha.

			if(bdUsuario.length() != 0)
				conexao = DriverManager.getConnection(bdUrl, bdUsuario, bdSenha);
			//Acesso direto � base de dados (sem usu�rio e senha).
			else
				conexao = DriverManager.getConnection(bdUrl);
			System.out.println("BD[Conexao OK]");
		}
		//Caso haja algum problema com o driver utilizado,
		//ser� gerada uma exce��o.
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver JDBC nao encontrado!");
		}
		//Caso haja algum problema com o comando SQL,
		//ser� gerada uma exce��o.
		catch(SQLException sqle){
			System.out.println("Problemas na conexao com a base de dados!");
			System.out.println(sqle.getMessage());
		}
	}
	//M�todo est�tico que retorna uma inst�ncia unica
	//da classe ConectaBD. Padr�o Singleton.
	public static ConectaBD getInstancia(){
		if(instancia == null)
			instancia = new ConectaBD();
		return instancia;
	}
	//M�todo para retornar a conex�o dispon�vel,
	//contabilizando a quantidade de clientes
	//acessando a base de dados.
	public Connection getConexao(){
		if(conexao == null)
			throw new RuntimeException("conexao == null");
		quantidadeDeConexoes++;
		System.out.println("BD[Cliente conectado]");
		return conexao;
	}
	//M�todo que decrementa o n�mero de clientes
	//conectados � base, efetuando o encerramento
	//da conex�o quando n�o restarem mais clientes.
	public void encerraConexao(){
		System.out.println("BD[Cliente desconectado]");
		quantidadeDeConexoes--;
		if(quantidadeDeConexoes > 0)
			return;
		try{
			conexao.close();
			instancia = null;
			System.out.println("BD[Conexao encerrada]");
			conexao = null;
		} catch(SQLException sqle){
			System.out.println("Problemas ao desconectar com a base de dados!");
		}
	}
	
}
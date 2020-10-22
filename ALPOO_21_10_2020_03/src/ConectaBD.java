import java.sql.*;
public class ConectaBD {
	//Variável estática que guardará a instância da classe ConectaBD.
	private static ConectaBD instancia = null;
	//Variavel para conexao à base de dados.
	private Connection conexao = null;
	//Variável para determinação da quantidade de clientes conectados à base.
	private int quantidadeDeConexoes = 0;
	//Construtor privado
	private ConectaBD(){
		try{
			//Propriedades da conexão à base de dados:
			//Especifica o driver JDBC utilizado.
			String bdDriver = "com.mysql.cj.jdbc.Driver";
			//Cria a url de acesso ao banco MySQL fornecendo:
			//o driver jdbc, o nome banco, o endereço (localhost
			//neste caso) com a porta de acesso e a base de
			//dados criada na aula passada.			
			String bdUrl = "jdbc:mysql://localhost:3306/alpoo?useTimezone=true&serverTimezone=UTC";
			//Define o usuário de acesso ao banco de dados.
			String bdUsuario = "ale";
			//Define a senha de acesso ao banco de dados.
			String bdSenha = "ale";
			//Carregamento dinâmico do driver por meio do método
			//forName(String) da classe Class.
			Class.forName(bdDriver);
			//Acesso à base de dados com usuário e senha.

			if(bdUsuario.length() != 0)
				conexao = DriverManager.getConnection(bdUrl, bdUsuario, bdSenha);
			//Acesso direto à base de dados (sem usuário e senha).
			else
				conexao = DriverManager.getConnection(bdUrl);
			System.out.println("BD[Conexao OK]");
		}
		//Caso haja algum problema com o driver utilizado,
		//será gerada uma exceção.
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver JDBC nao encontrado!");
		}
		//Caso haja algum problema com o comando SQL,
		//será gerada uma exceção.
		catch(SQLException sqle){
			System.out.println("Problemas na conexao com a base de dados!");
			System.out.println(sqle.getMessage());
		}
	}
	//Método estático que retorna uma instância unica
	//da classe ConectaBD. Padrão Singleton.
	public static ConectaBD getInstancia(){
		if(instancia == null)
			instancia = new ConectaBD();
		return instancia;
	}
	//Método para retornar a conexão disponível,
	//contabilizando a quantidade de clientes
	//acessando a base de dados.
	public Connection getConexao(){
		if(conexao == null)
			throw new RuntimeException("conexao == null");
		quantidadeDeConexoes++;
		System.out.println("BD[Cliente conectado]");
		return conexao;
	}
	//Método que decrementa o número de clientes
	//conectados à base, efetuando o encerramento
	//da conexão quando não restarem mais clientes.
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
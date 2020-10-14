import java.sql.*;

public class Conexao {
	public Connection conectar (){
		try	{
			/* SQLite
			Connection conn;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver JDBC encontrado!");
			String pathBD = System.getProperty("user.dir").replace("\\", "/");			
			String bdUrl = "jdbc:sqlite:"+pathBD+"/bd/ALPOO.db";
			conn = DriverManager.getConnection(bdUrl); 
			*/
			
			// MySQL
			
			Connection conn;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver JDBC encontrado!");

			//              jdbc:mysql://localhost:3306/jpadb?useTimezone=true&amp;serverTimezone=UTC
			String bdUrl = "jdbc:mysql://localhost:3306/alpoo?useTimezone=true&serverTimezone=UTC";
			String bdUsuario = "ale";
			String bdSenha = "ale";

			conn = DriverManager.getConnection(bdUrl,bdUsuario,bdSenha); 
			
			
			System.out.println("Conexao realizada com sucesso! Nome da Conexao: " + conn);
			return conn;
		}	
		catch(ClassNotFoundException ex){
			System.out.println("Driver JDBC n�o encontrado!  "+ex); 
			System.exit(0); 
			return null;
		}
		catch(SQLException ex){
			System.out.println("Problemas na conexao com a fonte de dados   ");
			return null;
		}
	}

	public void fecharConexao (Connection conn){
		try {
			conn.close();
			System.out.println("Conexao "+ conn + "  fechada com sucesso.");
		}
		catch(SQLException ex) {
			System.out.println("Problemas na conexao com a fonte de dados   "+ ex);
		}
	}

}

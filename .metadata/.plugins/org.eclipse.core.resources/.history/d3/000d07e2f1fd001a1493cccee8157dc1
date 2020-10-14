import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

public class TesteSqlite extends Tela implements ActionListener {
	
	private static Connection conn = null; 
	private static Statement stmt;
	static TesteSqlite x;
	private String pathBD;

	TesteSqlite(){
		this.btExecutar.addActionListener(this);
	}
	public Connection conectar (){
		try	{
			Connection c;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver JDBC encontrado!");
			pathBD = System.getProperty("user.dir").replace("\\", "/");			
			String bdUrl = "jdbc:sqlite:"+pathBD+"/bd/ALPOO.db";
			
			c = DriverManager.getConnection(bdUrl); 
			
			System.out.println("Conexao realizada com sucesso! Nome da Conexao: " + c);
			return c;
		}	
		catch(ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null,"Driver JDBC não encontrado!  "+ex,"Erro", JOptionPane.ERROR_MESSAGE);
			System.out.println("Driver JDBC não encontrado!  "+ex); System.exit(0); return null;
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"Problemas na conexao com a fonte de dados!\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);			
			System.out.println("Problemas na conexao com a fonte de dados   ");	return null;
		}
	}

	public void fecharConexao (Connection c){
		try {

			c.close();
			System.out.println("Conexao "+ c + "  fechada com sucesso.");
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problemas na conexao com a fonte de dados!\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);			
			System.out.println("Problemas na conexao com a fonte de dados   "+ ex);
		}
	}

	public void executeComando (String txtSQL){
		try{
			stmt = conn.createStatement();
			System.out.println("Comando: " + txtSQL);

			if (txtSQL.toUpperCase().contains("SELECT")) {
				ResultSet rs = stmt.executeQuery (txtSQL);
	
				// meta dados da tabela
				ResultSetMetaData rsmd = rs.getMetaData();  
			
				// retorna o numero total de colunas  
				int numColumns = rsmd.getColumnCount();  
				// monta os cabeçalhos
				for (int i=1; i <= numColumns; i++) {
					this.txtAreaResultado.setText(this.txtAreaResultado.getText()+
							rsmd.getColumnName(i)+"\t");
				}
				this.txtAreaResultado.setText(this.txtAreaResultado.getText()+"\n");
				Object valorColuna;
				
				// monta o resultado
				while (rs.next()){		
					for (int i=1; i <= numColumns; i++) {
						valorColuna = rs.getObject(i);		
						
						if (  valorColuna != null) {
							this.txtAreaResultado.setText(this.txtAreaResultado.getText()+valorColuna.toString()+"\t");
						} else {
							this.txtAreaResultado.setText(this.txtAreaResultado.getText()+"null\t");						
						}
					}
					this.txtAreaResultado.setText(this.txtAreaResultado.getText()+"\n");
				}
			} else {
				int r = stmt.executeUpdate (txtSQL);
			}
			
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro de execucao comando!\n"+txtSQL+"\n"+e,"Erro", JOptionPane.ERROR_MESSAGE);			
			System.out.println("Erro de execucao comando " + txtSQL);
		}
	}

	
	public static void main (String[] args){
		x = new TesteSqlite();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btExecutar) {
			this.txtAreaResultado.setText(null);
			conn = x.conectar();		
			x.executeComando(x.txtAreaComando.getText());
			x.fecharConexao(conn);
		}
	
	}
	

}

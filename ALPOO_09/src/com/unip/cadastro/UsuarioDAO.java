package com.unip.cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	
	private Conexao conexao = new Conexao();
	private String sqlInsert;
	private String sqlUpdate;
	private String sqlDelete;
	private String sqlSelect;	
	private String sqlSelectId;
	private String sqlSelectNome;
	private PreparedStatement st;
	private static Connection conn = null; 
	private String Mensagem;
	private boolean operacaoRealizada;
	//private static Usuario usuario = new Usuario();

	public boolean isOperacaoRealizada() {
		return operacaoRealizada;
	}

	public void setOperacaoRealizada(boolean operacaoRealizada) {
		this.operacaoRealizada = operacaoRealizada;
	}

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
	
	UsuarioDAO () {
		sqlInsert = "Insert Into Usuario (IdUsuario, Nome, Email, Telefone, Endereco) Values (?, ?, ?, ?, ?)";
		sqlUpdate = "Update Usuario Set Nome = ?, Email = ?, Telefone = ?, Endereco = ? Where IdUsuario = ?";
		sqlDelete = "Delete From Usuario Where IdUsuario = ?";
		sqlSelect = "Select IdUsuario, Nome, Email, Telefone, Endereco From Usuario";
		sqlSelectId = sqlSelect + " Where IdUsuario = ?"; 
		sqlSelectNome = sqlSelect + " Where Nome Like ?";
	}
	
	public boolean insert(Usuario usuario){
		conn = conexao.conectar();
		this.setMensagem("Inclusão realizada com sucesso!!!");
		boolean insert = true;
		this.setOperacaoRealizada(true);
		try {
			st = conn.prepareStatement(sqlInsert);
			st.setInt(1, usuario.getIdUsuario());
			st.setString(2, usuario.getNome());
			st.setString(3, usuario.getEmail());
			st.setString(4, usuario.getTelefone());
			st.setString(5, usuario.getEndereco());
			st.executeUpdate();
		} catch (SQLException e) {
			this.setMensagem("Erro de execução comando \n" + sqlInsert+"\n"+e);
			insert = false;
			this.setOperacaoRealizada(false);
		}
		finally{
			conexao.fecharConexao(conn);
		}
		return insert;
	}
	
	public boolean update(Usuario usuario){
		conn = conexao.conectar();
		this.setMensagem("Atualização realizada com sucesso!!!");
		boolean update = true;
		this.setOperacaoRealizada(true);
		try {
			st = conn.prepareStatement(sqlUpdate);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getEmail());
			st.setString(3, usuario.getTelefone());
			st.setString(4, usuario.getEndereco());
			st.setInt(5, usuario.getIdUsuario());			
			st.executeUpdate();
		} catch (SQLException e) {
			this.setMensagem("Erro de execução comando \n" + sqlUpdate+"\n"+e);
			update = false;
			this.setOperacaoRealizada(false);			
		}
		finally{
			conexao.fecharConexao(conn);
		}
		return update;
	}

	public boolean delete(int IdUsuario){
		conn = conexao.conectar();
		this.setMensagem("Exlusão realizada com sucesso!!!");
		boolean delete = true;
		this.setOperacaoRealizada(true);
		try {
			st = conn.prepareStatement(sqlDelete);
			st.setInt(1, IdUsuario);
			st.executeUpdate();
		} catch (SQLException e) {
			this.setMensagem("Erro de execução comando \n" + sqlDelete+"\n"+e);
			delete = false;
			this.setOperacaoRealizada(false);
		}
		finally{
			conexao.fecharConexao(conn);
		}
		return delete;
	}

	public Usuario select(int idUsuario){
		conn = conexao.conectar();
		Usuario usuario = new Usuario();
		this.setOperacaoRealizada(false);
		this.setMensagem("Usuário não encontrado!!!");
		try {
			st = conn.prepareStatement(sqlSelectId);
			st.setInt(1, idUsuario);			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()){
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEndereco(rs.getString("endereco"));
				this.setMensagem("Usuário encontrado!!!");
				this.setOperacaoRealizada(true);
			}
		}
		catch (SQLException e){
			this.setMensagem("Erro de execução comando \n" + sqlSelectId+"\n"+e);
			this.setOperacaoRealizada(false);
		}
		finally {
			conexao.fecharConexao(conn);
		}
		return usuario;
	}

	public Usuario select(String nome){
		conn = conexao.conectar();
		Usuario usuario = new Usuario();
		this.setOperacaoRealizada(false);
		this.setMensagem("Usuário não encontrado!!!");
		try {
			st = conn.prepareStatement(sqlSelectNome);
			st.setString(1, nome);			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()){
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEndereco(rs.getString("endereco"));
				this.setMensagem("Usuário encontrado!!!");
				this.setOperacaoRealizada(true);
			}
		}
		catch (SQLException e){
			this.setMensagem("Erro de execução comando \n" + sqlSelectNome+"\n"+e);
			this.setOperacaoRealizada(false);
		}
		finally {
			conexao.fecharConexao(conn);
		}
		return usuario;
	}


}

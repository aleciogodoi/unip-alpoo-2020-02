package com.unip.cadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CadastroController {

	private CadastroView cadastroView;
	private UsuarioDAO cadastroModel;
	
	public CadastroController(CadastroView view, UsuarioDAO model) {
		this.cadastroView = view;
		this.cadastroModel = model;
				
		this.cadastroView.addCadastroListener(new CadastroListener());
	}
	
	class CadastroListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "sair") {
				System.exit(0);
			} else if (e.getActionCommand() == "pesquisar") {
				pesquisar();
			} else if (e.getActionCommand() == "salvar") {
				salvar();
			} else if (e.getActionCommand() == "excluir") {
				excluir();
			} else if (e.getActionCommand() == "limpar") {
				cadastroView.limpar();
			}
		}	
		
		private void pesquisar() {

			if (cadastroView.txtCodigo.getText() !="") {
				Usuario usuario = new Usuario();
				usuario = cadastroModel.select(Integer.parseInt(cadastroView.txtCodigo.getText()));
				cadastroView.limpar();
				if (cadastroModel.isOperacaoRealizada()) {
					cadastroView.atualizar(usuario);
				} else {
					cadastroView.mensagem(cadastroModel.getMensagem());
				}
			}
		}
		
		private void salvar() {

			Usuario usuario = new Usuario();
			
			usuario.setIdUsuario(Integer.parseInt(cadastroView.txtCodigo.getText()));
			usuario.setNome(cadastroView.txtNome.getText());
			usuario.setEmail(cadastroView.txtEmail.getText());
			usuario.setEndereco(cadastroView.txtEndereco.getText());
			usuario.setTelefone(cadastroView.txtTelefone.getText());
			
			cadastroModel.select(Integer.parseInt(cadastroView.txtCodigo.getText()));
			
			if (cadastroModel.isOperacaoRealizada()) {	
				cadastroModel.update(usuario);
			} else {
				cadastroModel.insert(usuario);	
			}

			cadastroView.mensagem(cadastroModel.getMensagem());
		}
		
		private void excluir() {
			if (cadastroView.txtCodigo.getText() !="") {
				cadastroModel.delete(Integer.parseInt(cadastroView.txtCodigo.getText()));
				cadastroView.limpar();
				cadastroView.mensagem(cadastroModel.getMensagem());
			}
			
		}
	}	

}

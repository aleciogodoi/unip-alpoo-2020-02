package com.unip.cadastro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CadastroView extends JFrame  {
	JLabel lblCodigo, lblNome, lblEmail, lblTelefone, lblEndereco;
	JTextField txtCodigo, txtNome, txtEmail, txtTelefone, txtEndereco;
	JPanel painel2, painel3;
	JButton btSalvar, btPesquisar, btLimpar, btSair, btExcluir;
	
	CadastroView(){
		this.setTitle("Cadastro Usuários");
		this.setSize(500, 200);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(5,10));
		
		btPesquisar = new JButton("Pesquisar");
		btLimpar = new JButton("Limpar"); 
		btSalvar = new JButton("Salvar");
		btExcluir = new JButton("Excluir");		
		btSair  = new JButton("Sair");
		btSalvar.setActionCommand("salvar");
		btPesquisar.setActionCommand("pesquisar");
		btLimpar.setActionCommand("limpar");
		btSair.setActionCommand("sair");
		btExcluir.setActionCommand("excluir");

		painel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painel2.add(btPesquisar);
		painel2.add(btLimpar);
		painel2.add(btSalvar);
		painel2.add(btExcluir);
		painel2.add(btSair);
		
		painel3 = new JPanel(new GridLayout(5,2,10,5));
		lblCodigo = new JLabel("Código");
		lblNome = new JLabel("Nome");
		lblEmail = new JLabel("Email");
		lblTelefone = new JLabel("Telefone");
		lblEndereco = new JLabel("Endereço");
		txtCodigo = new JTextField();
		txtNome = new JTextField();
		txtEmail = new JTextField();
		txtTelefone = new JTextField();
		txtEndereco = new JTextField();
		painel3.add(lblCodigo);
		painel3.add(txtCodigo);
		painel3.add(lblNome);
		painel3.add(txtNome);
		painel3.add(lblEmail);
		painel3.add(txtEmail);
		painel3.add(lblTelefone);
		painel3.add(txtTelefone);
		painel3.add(lblEndereco);
		painel3.add(txtEndereco);
		painel3.setBackground(Color.WHITE);
		
		this.add(painel2, BorderLayout.SOUTH);
		this.add(painel3, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void limpar(){
		txtCodigo.setText(null);
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtEndereco.setText(null);
	}
	
	public void atualizar(Usuario usuario) {
		txtCodigo.setText(Integer.toString(usuario.getIdUsuario()));
		txtNome.setText(usuario.getNome());
		txtEmail.setText(usuario.getEmail());
		txtTelefone.setText(usuario.getTelefone());
		txtEndereco.setText(usuario.getEndereco());	
	}
	
	public void addCadastroListener(ActionListener listen){
		this.btExcluir.addActionListener(listen);
		this.btLimpar.addActionListener(listen);
		this.btPesquisar.addActionListener(listen);
		this.btSair.addActionListener(listen);
		this.btSalvar.addActionListener(listen);
	}
	
	// Mostra mensagem de erro
	void mensagem(String erro){
		JOptionPane.showMessageDialog(this, erro);
	}
	
}

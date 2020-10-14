package com.unip.calculadora;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculadoraView extends JFrame{

		private JButton btSoma, btSubtracao, btMultiplicacao, btDivisao, btPower;
		private JTextField txtNumero1, txtNumero2;
		private JLabel lblResultado;
		private JPanel painel;
		private JPanel painelBotoes;
		
		CalculadoraView(){

			this.setSize(300, 150);
			painel = new JPanel();
			painelBotoes = new JPanel();
			painel.setLayout( new GridLayout(4,1));
			painelBotoes.setLayout( new GridLayout(1,5));
			
			btSoma = new JButton("+");
			btSubtracao = new JButton("-");
			btMultiplicacao = new JButton("*");
			btDivisao = new JButton("/");
			btPower = new JButton("x^y");
			
			btSoma.setActionCommand("Soma");
			btSubtracao.setActionCommand("Subtração");
			btMultiplicacao.setActionCommand("Multiplicação");
			btDivisao.setActionCommand("Divisão");
			btPower.setActionCommand("x^y");
			
			lblResultado = new JLabel("");
			lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
			
			lblResultado.setForeground(Color.blue);
			
			txtNumero1 = new JTextField();
			txtNumero2 = new JTextField();
			txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
			txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
			
			painelBotoes.add(btSoma);		
			painelBotoes.add(btSubtracao);		
			painelBotoes.add(btMultiplicacao);		
			painelBotoes.add(btDivisao);		
			painelBotoes.add(btPower);		
			
			
			painel.add(lblResultado);
			painel.add(txtNumero1);
			painel.add(txtNumero2);
			painel.add(painelBotoes);
			
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(painel);
		}
		
		public int getNumero1(){	
			return Integer.parseInt(txtNumero1.getText());
		}
		
		public int getNumero2(){
			return Integer.parseInt(txtNumero2.getText());
		}
		
		public int getResultado(){	
			return Integer.parseInt(lblResultado.getText());
			
		}
		
		public void setResultado(int resultado){
			lblResultado.setText(Integer.toString(resultado));
		}

		// Quando o botão Soma for clicado o metodo será executado
		// no Controller teremos um metodo actionPerformed
		public void addCalculadoraListener(ActionListener listenParaCalculoBotao){
			btSoma.addActionListener(listenParaCalculoBotao);
			btSubtracao.addActionListener(listenParaCalculoBotao);
			btMultiplicacao.addActionListener(listenParaCalculoBotao);
			btDivisao.addActionListener(listenParaCalculoBotao);
			btPower.addActionListener(listenParaCalculoBotao);
		}
		
		// Mostra mensagem de erro
		void mostraErro(String erro){
			JOptionPane.showMessageDialog(this, erro);
		}
}

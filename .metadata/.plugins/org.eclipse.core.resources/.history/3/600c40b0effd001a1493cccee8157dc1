import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Tela extends JFrame{
	
	JTextArea txtAreaComando;
	JTextArea txtAreaResultado;
	JButton   btExecutar;
	JPanel painelBotao;
	public Tela(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Comandos SQL");
		this.setSize(700, 420);
		
		txtAreaComando = new JTextArea(10,20);
		txtAreaComando.setFont(new Font("courier new", Font.BOLD, 15));
		JScrollPane spComando = new JScrollPane(txtAreaComando);
		
		btExecutar = new JButton("Executar");
		painelBotao = new JPanel();
		painelBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
		painelBotao.add(btExecutar);

		txtAreaResultado = new JTextArea(10,20);
		JScrollPane spResultado = new JScrollPane(txtAreaResultado);

		this.add(spComando, BorderLayout.NORTH);
		this.add(painelBotao,BorderLayout.SOUTH);
		this.add(spResultado,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}

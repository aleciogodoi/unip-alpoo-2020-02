import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public  class Exemplo_05_ActionListener implements ActionListener {
	
	static TelaBase tela;
	static JButton btOk;
	static JButton btSair;
	static Exemplo_05_ActionListener testa;
	Exemplo_05_ActionListener(){
		tela = new TelaBase();
		tela.setLayout(new FlowLayout());
		btOk = new JButton("Ok");
		btSair = new JButton("Sair");
		
		tela.add(btOk);
		tela.add(btSair);
		
		btOk.addActionListener(this);
		btSair.addActionListener(this);
	}
	
	public static void main(String[] args) {
		testa = new Exemplo_05_ActionListener();
		testa.tela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btSair) {
			System.out.println("botão sair pressionado.");
			testa.tela.windowClosing(null);
		} else if(arg0.getSource() == btOk) {
			JOptionPane.showMessageDialog(null, "Botão Ok pressionado!");
		}
	}
}

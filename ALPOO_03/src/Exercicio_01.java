import java.awt.FlowLayout;

import javax.swing.JButton;

public class Exercicio_01 extends TelaBase {

	Exercicio_01(){
		this.setLayout( new FlowLayout());
		add(new JButton("Vermelho"));
		add(new JButton("Azul"));
		add(new JButton("Verde"));
		add(new JButton("Amarelo"));
		add(new JButton("Sair"));
	}
	
	public static void main(String[] args) {
		Exercicio_01 tela = new Exercicio_01();
		tela.setVisible(true);
	}

}

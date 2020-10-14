import java.awt.FlowLayout;

import javax.swing.JButton;

public class Exercicio_01_d extends TelaBase {

	Exercicio_01_d(){
		this.setLayout( new FlowLayout(FlowLayout.RIGHT));
		add(new JButton("Vermelho"));
		add(new JButton("Azul"));
		add(new JButton("Verde"));
		add(new JButton("Amarelo"));
		add(new JButton("Sair"));
	}
	
	public static void main(String[] args) {
		Exercicio_01_d tela = new Exercicio_01_d();
		tela.setVisible(true);
	}

}

import java.awt.FlowLayout;

import javax.swing.JButton;

public class Exercicio_01_c extends TelaBase {

	Exercicio_01_c(){
		this.setLayout( new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Vermelho"));
		add(new JButton("Azul"));
		add(new JButton("Verde"));
		add(new JButton("Amarelo"));
		add(new JButton("Sair"));
	}
	
	public static void main(String[] args) {
		Exercicio_01_c tela = new Exercicio_01_c();
		tela.setVisible(true);
	}

}

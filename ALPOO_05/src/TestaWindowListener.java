import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TestaWindowListener extends TelaBase implements ActionListener {
	static TestaWindowListener t01;
	static JButton btVermelho;
	static JButton btAzul;
	static JButton btVerde;
	static JButton btAmarelo;
	static JButton btSair;
	
	public static void main(String[] args) {
		t01 = new TestaWindowListener();
		
		btVermelho = new JButton("Vermelho");
		btAzul = new JButton("Azul");
		btVerde = new JButton("Verde");
		btAmarelo = new JButton("Amarelo");
		btSair = new JButton("Sair");
		btSair.setToolTipText("Clique aqui para Sair!");
		
		t01.setLayout(new FlowLayout());

		t01.add(btVermelho);
		t01.add(btAzul);
		t01.add(btVerde);
		t01.add(btAmarelo);
		t01.add(btSair);
		btVermelho.addActionListener(t01);
		btAzul.addActionListener(t01);
		btVerde.addActionListener(t01);
		btAmarelo.addActionListener(t01);
		btSair.addActionListener(t01);
		t01.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btVermelho) {
			t01.getContentPane().setBackground(Color.red);
		} else if (e.getSource() == btAzul) {
			t01.getContentPane().setBackground(Color.blue);
		} else if (e.getSource() == btVerde) {
			t01.getContentPane().setBackground(Color.green);
		} else if (e.getSource() == btAmarelo) {
			t01.getContentPane().setBackground(Color.yellow);
		} else if (e.getSource() == btSair) {
			t01.windowClosing(null);
		} 
		
	}

}

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends TelaBase {

	Calculadora(){
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setResizable(false);
		this.setSize(250, 150);
		this.setTitle("Calculadora");
		
		JLabel lblResultado = new JLabel();
		lblResultado.setBackground(Color.lightGray);
		lblResultado.setOpaque(true);
		add(lblResultado);

		JTextField txtNumero1 = new JTextField();
		add(txtNumero1);
	
		JTextField txtNumero2 = new JTextField();
		add(txtNumero2);

		JButton btSomar = new JButton("+");
		JButton btSubtrair = new JButton("-");
		JButton btMustiplicar = new JButton("*");
		JButton btDividir = new JButton("/");
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(1,4));

		painelBotoes.add(btSomar);
		painelBotoes.add(btSubtrair);
		painelBotoes.add(btMustiplicar);
		painelBotoes.add(btDividir);
		
		add(painelBotoes);
		
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		calc.setVisible(true);

	}

}

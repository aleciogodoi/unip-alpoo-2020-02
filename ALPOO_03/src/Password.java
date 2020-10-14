import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Password extends TelaBase {

	Password() {
		setTitle("Password");
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(new JLabel("Password"));
		add(new JPasswordField(10));
		
		JPanel painelBotoes = new JPanel();
		
		painelBotoes.setLayout(new GridLayout(0,1));
		painelBotoes.add(new JButton ("Ok"));
		painelBotoes.add(new JButton ("Cancelar"));
		add(painelBotoes);
		
		pack();
	}
	
	public static void main(String[] args) {
		Password pass = new Password();
		pass.setVisible(true);

	}

}

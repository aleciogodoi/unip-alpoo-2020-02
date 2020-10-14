import java.awt.*;
import javax.swing.*;

public class ExemploJFrame extends JFrame {
	public ExemploJFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize(); // Caputara o tamanho da tela
		setSize(d);   // Setando o tamanho da tela para o JFrame
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizando o JFrame
		setVisible(true);  // JFrame visivel
	}
	public static void main(String[] args) {
		ExemploJFrame tela = new ExemploJFrame();
		tela.getContentPane().setBackground(Color.black);
		tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}

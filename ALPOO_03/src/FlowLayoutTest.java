import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FlowLayoutTest extends JFrame {

	FlowLayoutTest() {
		//setSize(400, 350);
		setLayout(new FlowLayout());	

		add(new JTextField(10) );
		add(new JTextField(20) );

		add(new JButton("Um") );
		add(new JButton("Dois"));
		add(new JButton("Três"));
		pack();
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		FlowLayoutTest flowLayoutTest = new FlowLayoutTest();
		flowLayoutTest.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		flowLayoutTest.setVisible(true);
	}

}

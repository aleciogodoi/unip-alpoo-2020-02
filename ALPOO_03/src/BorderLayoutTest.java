import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
	BorderLayoutTest() {
		setSize(400, 350);
		setLayout(new BorderLayout());
		add( BorderLayout.NORTH,new JButton("Norte"));
		add( BorderLayout.EAST, new JButton("Leste"));
		add( BorderLayout.SOUTH, new JButton("Sul"));
		add( BorderLayout.WEST, new JButton("Oeste"));
		add( BorderLayout.CENTER, new JButton("Centro"));
	}
	
	public static void main(String[] args) {
		BorderLayoutTest borderLayoutTest = new BorderLayoutTest();
		borderLayoutTest.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		borderLayoutTest.setVisible(true);
	}
}


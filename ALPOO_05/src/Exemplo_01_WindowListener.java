import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class Exemplo_01_WindowListener extends JFrame implements WindowListener {
	Exemplo_01_WindowListener(){
		this.setSize(300, 300);
		this.setVisible(true);
		this.addWindowListener(this);  // Objeto associado ao ouvinte (Listener)
	}

	public static void main(String[] arg){
		Exemplo_01_WindowListener t1 = new Exemplo_01_WindowListener();
	}

	public void windowActivated(WindowEvent arg0) {
		System.out.println("windowActivated");
	}
	public void windowClosed(WindowEvent arg0) { 
		System.out.println("windowClosed");		
	}
	public void windowClosing(WindowEvent arg0) {	
		System.out.println("windowClosing");	
		System.exit(0);		
	}
	public void windowDeactivated(WindowEvent arg0) { 
		System.out.println("windowDeactivated");	
	}
	public void windowDeiconified(WindowEvent arg0) {
		System.out.println("windowDeiconified");	
	}
	public void windowIconified(WindowEvent arg0) {	
		System.out.println("windowIconified");	
	}
	public void windowOpened(WindowEvent arg0) {
		System.out.println("windowOpened");	
	}
}

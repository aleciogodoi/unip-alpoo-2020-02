import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Exemplo_02_MouseMotionListener extends JFrame implements MouseMotionListener, WindowListener{
	
	public Exemplo_02_MouseMotionListener() {
		this.setLayout(new FlowLayout());
		this.setSize(300,300);
		
		this.setVisible(true);
		this.addMouseMotionListener(this);	
		this.addWindowListener(this);
	}

	public static void main(String[] args){
		Exemplo_02_MouseMotionListener t1 = new Exemplo_02_MouseMotionListener();
	}
	
	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {	
		this.setTitle("X: "+arg0.getX() + "Y: "+arg0.getY());
		System.out.println("X: "+arg0.getX() + "Y: "+arg0.getY());
	}

	public void windowActivated(WindowEvent arg0) {
		System.out.println("windowActivated");
	}

	public void windowClosed(WindowEvent arg0) {
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
	}

}

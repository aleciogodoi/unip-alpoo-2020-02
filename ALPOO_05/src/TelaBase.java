import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class TelaBase extends JFrame implements WindowListener{
	
	TelaBase(){
		Dimension d01 = new Dimension(500,300);
		this.setSize(d01);
		this.addWindowListener(this);
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
}

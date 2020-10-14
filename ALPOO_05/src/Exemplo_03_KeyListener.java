
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JFrame;


public class Exemplo_03_KeyListener extends JFrame 
implements WindowListener, KeyListener{
	
	public Exemplo_03_KeyListener() {
		this.setLayout(new FlowLayout());
		this.setSize(300,300);
		
		this.setVisible(true);
		this.addWindowListener(this);
		this.addKeyListener(this);
	}

	public static void main(String[] args){
		Exemplo_03_KeyListener t1 = new Exemplo_03_KeyListener();
	}
	
	public void windowActivated(WindowEvent arg0) {
	}

	public void windowClosed(WindowEvent arg0) {
	}

	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent arg0) {
	}

	public void windowDeiconified(WindowEvent arg0) {
	}

	public void windowIconified(WindowEvent arg0) {
	}

	public void windowOpened(WindowEvent arg0) {
	}

	public void keyPressed(KeyEvent arg0) {
		System.out.print(arg0.getKeyChar());
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {		
	}

}

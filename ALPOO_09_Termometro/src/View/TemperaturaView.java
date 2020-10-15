package View;

//importa��o de classes e interfaces
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import Model.TemperaturaModel;
/*
classe abstrata para constru��o da interface gr�fica
e tratamento de eventos. Essa classe implementa a interface Observer
 */
abstract class TemperaturaView implements java.util.Observer {
	//atributos da classe TemperaturaView
	private String label;
	private TemperaturaModel model;
	JFrame temperaturaFrame;
	JTextField display = new JTextField();
	private JButton upButton = new JButton("Acima");
	private JButton downButton = new JButton("Abaixo");
	private JButton startStop = new JButton("Start");
	/*
	contrutor alternativo da classe TemperaturaView.
	cria��o e visualiza��o da interface gr�fica.
	 */
	TemperaturaView(String label, TemperaturaModel model, int h, int v) {
		this.label = label;
		this.model = model;
		temperaturaFrame = new JFrame(label);
		temperaturaFrame.add("North", new JLabel(label));
		temperaturaFrame.add("Center", display);
		JPanel buttons = new JPanel();
		buttons.add(upButton);
		buttons.add(downButton);
		buttons.add(this.startStop);
		temperaturaFrame.add("South", buttons);
		temperaturaFrame.addWindowListener(new CloseListener());
		model.addObserver(this); //conex�o de View para Model
		temperaturaFrame.setSize(300,120);
		temperaturaFrame.setLocation(h,v);
		temperaturaFrame.setVisible(true);
	}
	//m�todo para atualizar o campo texto
	public void setDisplay(String s){
		display.setText(s);
	}
	//m�todo para capturar informa��o do campo texto
	public double getDisplay() {
		double resultado = 0.0;
		try {
			return Double.valueOf(display.getText()); //.doubleValue();
		}
		catch(NumberFormatException e){
			return resultado;
		}
	}
	//m�todos tratadores para o evento de a��o sobre os bot�es
	public void addDisplayListener(ActionListener a){display.addActionListener(a);}
	public void addUpListener(ActionListener a){upButton.addActionListener(a);}
	public void addDownListener(ActionListener a){downButton.addActionListener(a);}
	public void addStartStop(ActionListener a){startStop.addActionListener(a);}
	//m�todo para retornar o model atual
	protected TemperaturaModel model(){return model;}
	//classe interna para fechar as janelas
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}
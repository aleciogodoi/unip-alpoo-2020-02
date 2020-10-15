package View;

//importação de classes e interfaces
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import Model.TemperaturaModel;
/*
classe abstrata para construção da interface gráfica
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
	criação e visualização da interface gráfica.
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
		model.addObserver(this); //conexão de View para Model
		temperaturaFrame.setSize(300,120);
		temperaturaFrame.setLocation(h,v);
		temperaturaFrame.setVisible(true);
	}
	//método para atualizar o campo texto
	public void setDisplay(String s){
		display.setText(s);
	}
	//método para capturar informação do campo texto
	public double getDisplay() {
		double resultado = 0.0;
		try {
			return Double.valueOf(display.getText()); //.doubleValue();
		}
		catch(NumberFormatException e){
			return resultado;
		}
	}
	//métodos tratadores para o evento de ação sobre os botões
	public void addDisplayListener(ActionListener a){display.addActionListener(a);}
	public void addUpListener(ActionListener a){upButton.addActionListener(a);}
	public void addDownListener(ActionListener a){downButton.addActionListener(a);}
	public void addStartStop(ActionListener a){startStop.addActionListener(a);}
	//método para retornar o model atual
	protected TemperaturaModel model(){return model;}
	//classe interna para fechar as janelas
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}
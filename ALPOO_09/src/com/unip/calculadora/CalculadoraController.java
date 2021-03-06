package com.unip.calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraController {
	
	private CalculadoraView calculadoraView;
	private CalculadoraModel calculadoraModel;
	
	public CalculadoraController(CalculadoraView view, CalculadoraModel model) {
		this.calculadoraView = view;
		this.calculadoraModel = model;
		
		// Diz para a classe CalculadoraView, que sempre que bot�es forem clicados
		// ser� executado o metodo actionPerformed da classe CalculadoraListener
		
		this.calculadoraView.addCalculadoraListener(new CalculadoraListener());
	}
	
	class CalculadoraListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int numero1, numero2 = 0;
			
			try{
				numero1 = calculadoraView.getNumero1();
				numero2 = calculadoraView.getNumero2();

				if (e.getActionCommand() =="Soma") {
					calculadoraModel.soma(numero1, numero2);			
				} else  if (e.getActionCommand() =="Subtra��o") {
					calculadoraModel.subtrai(numero1, numero2);
				} else  if (e.getActionCommand() =="Multiplica��o") {
					calculadoraModel.multiplica(numero1, numero2);
				}  else  if (e.getActionCommand() =="Divis�o") {
					calculadoraModel.divide(numero1, numero2);
				}  else  if (e.getActionCommand() == "x^y") {
					calculadoraModel.power(numero1, numero2);
				}	
				calculadoraView.setResultado(calculadoraModel.getResultado());
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
				calculadoraView.mostraErro("S�o necess�rios dois n�meros");
			}	
		}	
	}	
}
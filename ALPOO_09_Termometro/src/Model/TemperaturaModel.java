package Model;
import java.util.*;
/*
classe externa respons�vel pelas regras de neg�cio
relacionadas �s convers�es da temperatura. 
Essa classe
estende a classe Observable
 */
public class TemperaturaModel extends java.util.Observable {
	//atributo privado
	private double temperaturaF = 32.0;
	//m�todo para consulta da temperatura farenheit
	public double getTemperaturaF() {
		return temperaturaF;
	}
	
	//m�todo para atualiza��o da temperatura farenheit
	public void setTemperaturaF(double temperaturaF) {
		this.temperaturaF = temperaturaF;
		setChanged();
		notifyObservers();
	}
	
	//m�todo para altera��o e consulta da temperatura celcius
	public double getTemperaturaC() {
		return Math.round((temperaturaF - 32.0)*5.0/9.0);
	}
	
	//m�todo para altera��o da temperatura farenheit
	public void setTemperaturaC(double temperaturaC) {
		temperaturaF = Math.round(temperaturaC*9.0/5.0 + 32.0);
		setChanged();
		notifyObservers();
	}
}
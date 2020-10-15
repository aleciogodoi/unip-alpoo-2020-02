package Model;
import java.util.*;
/*
classe externa responsável pelas regras de negócio
relacionadas às conversões da temperatura. 
Essa classe
estende a classe Observable
 */
public class TemperaturaModel extends java.util.Observable {
	//atributo privado
	private double temperaturaF = 32.0;
	//método para consulta da temperatura farenheit
	public double getTemperaturaF() {
		return temperaturaF;
	}
	
	//método para atualização da temperatura farenheit
	public void setTemperaturaF(double temperaturaF) {
		this.temperaturaF = temperaturaF;
		setChanged();
		notifyObservers();
	}
	
	//método para alteração e consulta da temperatura celcius
	public double getTemperaturaC() {
		return Math.round((temperaturaF - 32.0)*5.0/9.0);
	}
	
	//método para alteração da temperatura farenheit
	public void setTemperaturaC(double temperaturaC) {
		temperaturaF = Math.round(temperaturaC*9.0/5.0 + 32.0);
		setChanged();
		notifyObservers();
	}
}
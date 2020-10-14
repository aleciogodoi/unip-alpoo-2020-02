package com.unip.calculadora;

public class CalculadoraModel {
	private int resultado;

	public void soma(int numero1, int numero2){
		resultado = numero1 + numero2;	
	}

	public void subtrai(int numero1, int numero2){
		resultado = numero1 - numero2;	
	}
	
	public void multiplica(int numero1, int numero2){	
		resultado = numero1 * numero2;	
	}
	
	public void divide(int numero1, int numero2){	
		resultado = numero1 / numero2;	
	}
	
	public void power(int x, int y) {
		resultado = (int) Math.pow((double)x, (double)y);
	}
	
	public int getResultado(){
		return resultado;		
	}	
	

}
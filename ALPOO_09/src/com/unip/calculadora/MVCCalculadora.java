package com.unip.calculadora;

public class MVCCalculadora {
    
    public static void main(String[] args) {	       
        CalculadoraView view = new CalculadoraView();
    	CalculadoraModel model = new CalculadoraModel();      
        CalculadoraController controller = new CalculadoraController(view,model);
        view.setVisible(true);
    }
}
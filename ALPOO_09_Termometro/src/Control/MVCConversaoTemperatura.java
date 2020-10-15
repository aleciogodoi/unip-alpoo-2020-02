package Control;

import java.util.Random;

//importa��o de classes e interfaces
import Model.TemperaturaModel;
import View.FarenheitView;
import View.GraficoView;
import View.CelsiusView;
//classe externa para controle da convers�o de temperatura
public class MVCConversaoTemperatura {
	//m�todo principal
	public static void main(String[] args) {
		//cria��o do objeto temperatura - inst�ncia da classe TemperaturaModel
		TemperaturaModel temperatura = new TemperaturaModel();
		
		//objeto an�nimo - inst�ncia da classe FarenheitView
		new FarenheitView(temperatura, 100, 200);

		//objeto an�nimo - inst�ncia da classe CelciusView	
		new CelsiusView(temperatura, 100, 350);
		
		//objeto an�nimo - inst�ncia da classe CelciusView	
		
		new GraficoView(temperatura, 400, 200);

		Random rnd = new Random();
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temperatura.setTemperaturaC(rnd.nextInt(200));
		}
	
	}
}
package Control;

import java.util.Random;

//importação de classes e interfaces
import Model.TemperaturaModel;
import View.FarenheitView;
import View.GraficoView;
import View.CelsiusView;
//classe externa para controle da conversão de temperatura
public class MVCConversaoTemperatura {
	//método principal
	public static void main(String[] args) {
		//criação do objeto temperatura - instância da classe TemperaturaModel
		TemperaturaModel temperatura = new TemperaturaModel();
		
		//objeto anônimo - instância da classe FarenheitView
		new FarenheitView(temperatura, 100, 200);

		//objeto anônimo - instância da classe CelciusView	
		new CelsiusView(temperatura, 100, 350);
		
		//objeto anônimo - instância da classe CelciusView	
		
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
package View;

//importanção de classes e interfaces
import Model.TemperaturaModel;
import java.util.Observable;
import java.util.Random;
import java.awt.event.*;
/*
classe externa para tratamento da temperatura em celsius.
Essa classe estende a classe TemperaturaView
*/
public class CelsiusView extends TemperaturaView {
	//construtor alternativo para a classe celsiusView
	public CelsiusView(TemperaturaModel model, int h, int v) {
		super("Temperatura celsius", model, h, v);
		setDisplay("" + model.getTemperaturaC());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
		addStartStop(new StartStop());
	}
	
	//método para atualizar a temperatura em celsius
	public void update(Observable t, Object o) {//chamada ao model
		setDisplay("" + model().getTemperaturaC());
	}
	
	//Classes internas para tratamento do evento de ação sobre a temperatura celsius
	class UpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model().setTemperaturaC(model().getTemperaturaC() + 1.0);
		}
	}
	class DownListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			model().setTemperaturaC(model().getTemperaturaC() - 1.0);
		}
	}
	class StartStop implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			model().setTemperaturaC(0);
		}
	}
	class DisplayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = getDisplay();
			model().setTemperaturaC(value);
		}
	}
}
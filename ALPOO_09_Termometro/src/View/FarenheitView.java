package View;
//importanção de classes e interfaces
import Model.TemperaturaModel;
import java.util.Observable;
import java.awt.event.*;
/*
classe externa para tratamento da temperatura em Farenheit.
Essa classe estende a classe TemperaturaView
 */
public class FarenheitView extends TemperaturaView {
	//construtor alternativo para a classe FarenheitView
	public FarenheitView(TemperaturaModel model, int h, int v) {
		super("Temperatura Farenheit", model, h, v);
		setDisplay("" + model.getTemperaturaF());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
		addStartStop(new StartStop());
	}
	
	//método para atualizar a temperatura em farenheit
	public void update(Observable t, Object o) {//chamada ao model
		setDisplay("" + model().getTemperaturaF());
	}
	class UpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model().setTemperaturaF(model().getTemperaturaF() + 1.0);
		}
	}
	
	//Classes internas para tratamento do evento de ação sobre a temperatura farenheit
	class DownListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model().setTemperaturaF(model().getTemperaturaF() - 1.0);
		}
	}	
	
	class StartStop implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model().setTemperaturaF(32);
		}
	}
	class DisplayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = getDisplay();
			model().setTemperaturaF(value);
		}
	}
}
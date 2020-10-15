package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.JThermometer;
import org.jfree.data.general.DefaultValueDataset;


import Model.TemperaturaModel;

public class GraficoView extends TemperaturaView {

	private  JThermometer term = new JThermometer();
	
	public GraficoView(TemperaturaModel model, int h, int v) {

		super("Gráfico - Temperatura", model, h, v);

		// Termometro
		term.setValue(model().getTemperaturaC());
		term.setOutlinePaint(null);
		term.setUnits(0);
		term.setForeground(Color.blue);
		term.setBackground(Color.white);
		// Range
		term.setRange(0.0,200.0);
		// 0 = verde, 1= amarelo 2= vermelho
		//term.setSubrangeInfo(2, 80.0, 100.0, 22.0, 40.0);
		//term.setSubrangeInfo(1, 50.0, 80.0, 18.0, 26.0);
		//term.setSubrangeInfo(0, 0.0, 50.0, 0.0, 100.0);
		
		//term.setSubrangeInfo(0, 0.0, 00.0, 0.0, 100.0);
		//term.setSubrangeInfo(1, 00.0, 00.0, 18.0, 26.0);		
		//term.setSubrangeInfo(2, 0.0, 100.0, 22.0, 40.0);
			
		term.setSubrangeInfo(0, 0.0, 000.0);
		term.setSubrangeInfo(1, 0.0, 000.0);		
		term.setSubrangeInfo(2, 0.0, 200.0);
		
		
		term.addSubtitle("", new Font("SansSerif", Font.PLAIN, 16));
		// Formato dos valores
		//term.setValueFormat(new DecimalFormat("#0.0"));
		term.setValueFormat(new DecimalFormat("#0"));

		temperaturaFrame.add("Center", term);

		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());	
		addStartStop(new StartStop());
		this.temperaturaFrame.setSize(500, 300);
		this.temperaturaFrame.setResizable(false);
	
		this.display.setVisible(false);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		term.setValue(model().getTemperaturaC());		
	}

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

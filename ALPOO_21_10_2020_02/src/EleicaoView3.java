
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class EleicaoView3 extends JFrame implements Observer {
	private Observable eleicao;

	static JLabel[] lblCandidato;
	static JLabel[] lblVoto;
	static JPanel painel;
	private int total;
	private String aux;
	
	EleicaoView3(Observable eleicao) {
		this.eleicao = eleicao;
		eleicao.addObserver(this);		

		total = ((Eleicao) this.eleicao).getCandidatos().length;
		this.setTitle("Votação");
		lblCandidato = new JLabel[total];
		lblVoto = new JLabel[total];
		
		JPanel painel = new JPanel(new GridLayout(total, 2));
		
		for (int i=0; i < total; i++) {
			aux = ((Eleicao) this.eleicao).getCandidato(i);
			lblCandidato[i] = new JLabel(aux);
			aux = String.valueOf(((Eleicao) this.eleicao).getVoto(i));
			lblVoto[i] = new JLabel(aux, SwingConstants.RIGHT);
			painel.add(lblCandidato[i]);
			painel.add(lblVoto[i]);

		}
		this.add(painel);
		this.setLocation(100, 300);
	}

	@Override
	public void update(Observable eleicaoObj, Object arg) {
		Eleicao eleicao = (Eleicao) eleicaoObj;
		for (int i=0; i < total; i++) {
			aux = String.valueOf(((Eleicao) this.eleicao).getVoto(i));
			lblVoto[i].setText(aux);
		}
	}
	
}
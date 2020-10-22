import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// View
public class Votacao extends JFrame implements ActionListener{
	
	static JButton[] btCandidato;
	static JLabel titulo;
	static JPanel painel;
	private Eleicao eleicao;

	Votacao(Eleicao eleicao) {
		this.eleicao = eleicao;
		int total = eleicao.getCandidatos().length;
		this.setTitle("Votação");
		btCandidato = new JButton[total];
		
		JPanel painel = new JPanel(new GridLayout(total+1, 1));
		
		titulo = new JLabel("Escolha um Candidato");
		painel.add(titulo);
		
		for (int i=0; i < total; i++) {
			btCandidato[i] = new JButton(eleicao.getCandidato(i));
			painel.add(btCandidato[i]);
			btCandidato[i].addActionListener(this);
			btCandidato[i].setActionCommand(String.valueOf(i));
		}
		this.add(painel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i = Integer.valueOf(arg0.getActionCommand());
		eleicao.setVoto(i);
	}
}

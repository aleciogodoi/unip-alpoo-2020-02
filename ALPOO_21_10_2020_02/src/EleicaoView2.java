import java.util.Observable;
import java.util.Observer;

public class EleicaoView2 implements Observer{

	private Observable eleicao;

	public EleicaoView2(Observable eleicao) {
		this.eleicao = eleicao;
		eleicao.addObserver(this);
	}
	
	@Override
	public void update(Observable eleicaoObj, Object arg) {
		Eleicao eleicao = (Eleicao) eleicaoObj;
		
		String[] candidatos = eleicao.getCandidatos();
		int[] votos = eleicao.getVotos();
		int total = 0;
		for (int i=0; i < candidatos.length; i++) {
			total += votos[i];
		}
		System.out.println("Total de Votos: " + total + "\n");		
	}
}

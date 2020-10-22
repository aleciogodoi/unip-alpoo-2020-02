import java.util.Observable;
import java.util.Observer;

public class EleicaoView implements Observer{

	private Observable eleicao;

	public EleicaoView(Observable eleicao) {
		this.eleicao = eleicao;
		eleicao.addObserver(this);
	}

	@Override
	public void update(Observable eleicaoObj, Object arg) {
		Eleicao eleicao = (Eleicao) eleicaoObj;
		
		String[] candidatos = eleicao.getCandidatos();
		int[] votos = eleicao.getVotos();
		
		for (int i=0; i < candidatos.length; i++) {
			System.out.println(candidatos[i] +
					"\t Votos: "+votos[i]);
		}
		System.out.println("--------------------------------");		
	}

}

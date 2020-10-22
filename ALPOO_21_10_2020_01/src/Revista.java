import java.util.Observable;
import java.util.Observer;

public class Revista extends Observable {

	private static int edicao;
	private String mens;

	public void setNovaEdicao(int novaEdicao) {
		this.edicao = novaEdicao;
		setChanged();
		notifyObservers();
	}

	public void setNovaEdicao() {
		this.edicao++;
		setChanged();
		notifyObservers();
	}

	public int getEdicao() {
		return this.edicao;
	}


	public void setMens(String mens) {
		this.mens = mens;
		setChanged();
		notifyObservers();
	}
	
	public String getMens() {
		return this.mens;
	}
	
}

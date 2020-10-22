import java.util.Observable;
import java.util.Observer;

class Assinante implements Observer {

	String nome;
	Revista revista;

	public Assinante(Revista revista, String nome) {
		this.revista = revista;
		this.nome = nome;
		this.revista.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
			
			System.out.println("Atenção "+ this.nome +" já chegou "
					+ "mais uma edição da sua revista. " +
					"Esta é a edição número: " + this.revista.getEdicao() + "\n"
							+ this.revista.getMens() );
	}
}

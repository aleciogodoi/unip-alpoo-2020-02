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
			
			System.out.println("Aten��o "+ this.nome +" j� chegou "
					+ "mais uma edi��o da sua revista. " +
					"Esta � a edi��o n�mero: " + this.revista.getEdicao() + "\n"
							+ this.revista.getMens() );
	}
}

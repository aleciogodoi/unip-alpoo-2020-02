import java.util.Observable;
// Modelo
public class Eleicao extends Observable {

	private String [] candidatos = {
			"Betty Boo","Andrade","Batman", "Flash",
			"Mulher Maravilha","Hello Kitty",
			"Mickey","Pluto", "Bob Esponja", 
			"Patrick", "Galinha Pintadinha","Kick Butovisk", "Coringa"};
	private int [] votos = {0,0,0,0,0,0,0,0,0,0,0,0,0};

	public String[] getCandidatos() {
		return candidatos;
	}
	public String getCandidato(int IdCandidato) {
		return candidatos[IdCandidato];
	}
	public void setCandidatos(String[] candidatos) {
		this.candidatos = candidatos;
	}
	public int[] getVotos() {
		return votos;
	}
	public int getVoto(int IdCandidato) {
		return votos[IdCandidato];
	}
	public void setVoto(int idCandidato) {
		this.votos[idCandidato]++;
		setChanged();
		notifyObservers();
	}
}

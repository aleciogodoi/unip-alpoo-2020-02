import java.util.ArrayList;
public class Teste {
	public static void main(String[] args) {	
		String nomes[] = {"Jo�o","Pedro","Ana","Maria","Vanessa", "Jos�"};
		Revista revista = new Revista();
		ArrayList<Assinante> assinantes = new ArrayList<Assinante>();
		for (int i=0; i < nomes.length; i++) {
			Assinante assinante = new Assinante(revista, nomes[i]);
			assinantes.add(assinante);
		}
		//revista.setNovaEdicao(50);
		//System.out.println();
		revista.setNovaEdicao();
		revista.setMens("Aviso qualquer!!!");
	}
}

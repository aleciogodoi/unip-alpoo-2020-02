// Controle
public class TesteEleicao {
	public static void main(String[] args) {
		Eleicao eleicao = new Eleicao();
		
		Votacao votacao = new Votacao(eleicao);
		votacao.setVisible(true);
		votacao.pack();

		EleicaoView3 viewFrame = new EleicaoView3(eleicao);
		viewFrame.setVisible(true);
		viewFrame.pack();
		
		EleicaoView2 viewTotal = new EleicaoView2(eleicao);
		EleicaoView view = new EleicaoView(eleicao);
	}
}
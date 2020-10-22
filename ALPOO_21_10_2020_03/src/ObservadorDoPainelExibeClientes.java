import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
public class ObservadorDoPainelExibeClientes implements ActionListener, WindowListener {
	//Atributos privados.
	private PainelExibeClientes pec;
	private JanelaExibeDados jed;
	//Construtores, um para o painel, outro para o frame.
	public ObservadorDoPainelExibeClientes(PainelExibeClientes painel){
		pec = painel;
	}
	public ObservadorDoPainelExibeClientes(JanelaExibeDados janela){
		jed = janela;
	}
	//Este método é chamado pelo sistema em tempo de execução.
	//Você deve adicionar o código a ser executado
	//em resposta à carga da tabela no painel.
	public void actionPerformed(ActionEvent evento){
		//Início do seu código:
		pec.carregarClientes();
	}
	//Este método é chamado pelo sistema em tempo de execução.
	//Você deve adicionar o código a ser executado
	//em resposta ao fechamento do frame.
	public void windowClosing(WindowEvent e){
		//Início do seu código:
		jed.encerrarConexao();
	}
	//Métodos de implementação obrigatória, são necessários
	//para que a classe não gere erros e compile corretamente,
	//mas não serão utilizados para este exemplo.
	public void windowDeiconified(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowIconified(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowActivated(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowClosed(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowOpened(WindowEvent e){
		System.out.println(e.toString());
	}
}
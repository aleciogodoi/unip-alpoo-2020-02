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
	//Este m�todo � chamado pelo sistema em tempo de execu��o.
	//Voc� deve adicionar o c�digo a ser executado
	//em resposta � carga da tabela no painel.
	public void actionPerformed(ActionEvent evento){
		//In�cio do seu c�digo:
		pec.carregarClientes();
	}
	//Este m�todo � chamado pelo sistema em tempo de execu��o.
	//Voc� deve adicionar o c�digo a ser executado
	//em resposta ao fechamento do frame.
	public void windowClosing(WindowEvent e){
		//In�cio do seu c�digo:
		jed.encerrarConexao();
	}
	//M�todos de implementa��o obrigat�ria, s�o necess�rios
	//para que a classe n�o gere erros e compile corretamente,
	//mas n�o ser�o utilizados para este exemplo.
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
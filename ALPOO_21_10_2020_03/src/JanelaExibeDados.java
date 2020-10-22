import java.awt.*;
import javax.swing.*;
public class JanelaExibeDados extends JFrame {
	//Construtor
	public JanelaExibeDados(){
		//Cria e insere um objeto PainelExibeClientes.
		PainelExibeClientes pec = new PainelExibeClientes();
		this.getContentPane().add(pec, BorderLayout.CENTER);
		//Instancia o observador deste frame.
		ObservadorDoPainelExibeClientes odpec = new ObservadorDoPainelExibeClientes(this);
		this.addWindowListener(odpec);
		//Fecha o frame.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	//M�todo para encerrar a conex�o com o banco de dados.
	public void encerrarConexao(){
		ConectaBD.getInstancia().encerraConexao();
	}
	//M�todo execut�vel.
	public static void main(String[] args){
		JanelaExibeDados jed = new JanelaExibeDados();
		jed.setTitle("Usu�rios");
		jed.setVisible(true);
	}
}
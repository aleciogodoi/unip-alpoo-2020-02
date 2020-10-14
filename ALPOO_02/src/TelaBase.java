import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//a. A classe TelaBase deve ser herdeira (extends) da classe Frame;
public class TelaBase extends Frame {
	//b i. Crie um objeto d01 do tipo Dimension com 300 por 300;
	Dimension d01;
	//b. Crie um construtor básico para a classe TelaBase:
	TelaBase() {
		d01 = new Dimension(300, 300);
		
		//b ii. O título da janela deve ser "Tela Base - Utilizando AWT";
		this.setTitle("Tela Base - Utilizando AWT");
		
		//b iii. Utilize o objeto d01 para definir o tamanho da janela;
		this.setSize(d01);
		
		// Centralizando a Janela
		setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2
		);

		//b iv.	Acrescente o código abaixo para fazer o fechamento da tela
		// Fechamento da Janela
		addWindowListener((WindowListener) new WindowAdapter(){  
				public void windowClosing(WindowEvent e) {  
						dispose();  
				}  
		});  

	}
}

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
//a. Crie uma classe chamada TelaEmail que possua um método main:
public class TelaEmail {
	public static void main(String[] args) {
		//i.	No método main crie um objeto chamado t01 do tipo TelaBase;
		TelaBase t01 = new TelaBase();
		//ii.	Altere o título da janela para “Email”; 
		t01.setTitle("Email");
		//iii.	A tela deve ter o tamanho de 300 x 160
		t01.setSize(300, 160);
		//iv.	Configure a janela para NÃO utilizar um gerenciador de layout;
		t01.setLayout(null);
		// label lb01 - Nome
		Label lb01 = new Label("Nome");
		lb01.setSize(50, 20);
		lb01.setLocation(20, 50);
		t01.add(lb01);
		// txNome - Nome
		TextField txNome = new TextField();
		txNome.setBounds(100, 50,170, 20);
		t01.add(txNome);
		// label lb02 - Email
		Label lb02 = new Label("Email");
		lb02.setBounds(20, 80, 50, 20);
		t01.add(lb02);
		// txEmail - Email
		TextField txEmail = new TextField();
		txEmail.setBounds(100, 80, 170, 20);
		t01.add(txEmail);
		// btCancelar
		Button btCancelar = new Button("Cancelar");
		btCancelar.setBounds(20, 120, 120, 20);
		t01.add(btCancelar);
		// btOk 
		Button btOk = new Button("Ok");
		btOk.setBounds(150, 120, 120, 20);
		t01.add(btOk);
		t01.setVisible(true);
		
	}
}

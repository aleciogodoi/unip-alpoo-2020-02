import java.awt.Color;
import java.awt.Frame;
//a.Criar um novo projeto JAVA com o seguinte nome: “ALPOO_02”;
//b. Criar uma classe chamada “Tela01”, que possua um método main;

public class Tela01 {
	public static void main(String[] args) {
		//c.Instanciar um objeto chamado “t01” do tipo Frame (no método main);
		Frame t01 = new Frame();
		
		//d.  Defina o título de “t01” para “Tela 01 - Utilizando AWT”;
		//2a. Título de “t01” para “Tela 01 - Utilizando AWT – Versão 2.0”;
		t01.setTitle("Tela 01 - Utilizando AWT - Versão 2.0");

		//e.  Defina o tamanho da janela com 700px de comprimento e 400px de largura
		//2b. Alterar o tamanho da janela para 700px de comprimento e 400px de largura
		t01.setSize(700, 400);
		
		//f.Deixe a janela visível 
		t01.setVisible(true);
		
		//2c. Alterar o posicionamento da tela para: 100 e 100
		t01.setLocation(100, 200);
		
		//2d. Alterar a cor de fundo da janela para azul
		t01.setBackground(Color.blue);
		
		//2e. Não permitir que a janela seja redimensionada
		t01.setResizable(false);
		
	}
}

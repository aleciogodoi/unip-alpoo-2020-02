import java.awt.Color;

//c. Crie uma classe chamada TestaTela que possua um método main:
public class TestaTela {
	public static void main(String[] args) {
		//c i.	No método main crie um objeto chamado t01 do tipo TelaBase;
		TelaBase t01 = new TelaBase();
		//c ii.	Faça com que t01 seja visível;
		t01.setVisible(true);
		t01.setLocation(0, 0);
		//c iii.	A cor de fundo da janela deve ser verde;
		t01.setBackground(Color.green);
		//c iv.	Esta tela não deve ser redimensionada;
		t01.setResizable(false);
		//vi.	Crie um novo objeto do tipo TelaBase, chamado t02;
		TelaBase t02 = new TelaBase();
		//vii.	O título deve ser "Tela Base - Tela 02";
		t02.setTitle("Tela Base - Tela 02");
		//viii.	A cor de fundo deve ser amarela;
		t02.setBackground(Color.yellow);
		//ix.	O local da nova janela deve ter as seguintes coordenadas: x = 300 e y = 0;
		t02.setLocation(300, 0);
		//x.	Deixar a janela visível;
		t02.setVisible(true);
	}
}

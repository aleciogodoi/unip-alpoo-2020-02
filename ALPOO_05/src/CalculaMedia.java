import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculaMedia extends TelaBase implements ActionListener {

    JButton btCalcular;
    JButton btSair;
    
    float nota1, nota2, media;
    
    JLabel lblNota1;
    JLabel lblNota2;
    JLabel lblMedia;
    JLabel lblValorMedia;

    JTextField txtNota1;
    JTextField txtNota2;
    
    static CalculaMedia t01;
    
    CalculaMedia(){
    	this.setLayout(new GridLayout(4,2,10,10));
    	this.setTitle("Cálculo de Médias");
    	this.setSize(300,150);
    	this.setResizable(false);

    	btCalcular = new JButton("Calcular");
    	btSair = new JButton("Sair");
    	lblNota1 = new JLabel("Nota 1");
    	lblNota2 = new JLabel("Nota 2");
    	lblMedia = new JLabel("Média");
    	txtNota1 = new JTextField();
    	txtNota2 = new JTextField();
    	lblValorMedia = new JLabel();
    		
    	this.add(lblNota1);
    	this.add(txtNota1);
    	this.add(lblNota2);
    	this.add(txtNota2);    	
    	this.add(lblMedia);
    	this.add(lblValorMedia);    	
    	this.add(btCalcular);
    	this.add(btSair);
    	btCalcular.addActionListener(this);
    	btSair.addActionListener(this);
    	
    }
    
	public static void main(String[] args) {
		t01 = new CalculaMedia();
		t01.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double media=0;
		if (e.getSource() == btCalcular) {
			try {
				double nota1 = Double.valueOf(txtNota1.getText());
				double nota2 = Double.valueOf(txtNota2.getText());
				
				
				if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 ) {
					lblValorMedia.setText("Números entre 0 e 10!!!");
				} else {
					media = (nota1 + nota2) / 2;
					lblValorMedia.setText(String.valueOf(media));
				}			
				
			} catch (NumberFormatException erro) {
				lblValorMedia.setText("Números Inválidos!!!");
			}
			
			System.out.println(media);
			if (media >= 7.0) 
				lblValorMedia.setForeground(Color.blue);
			else
				lblValorMedia.setForeground(Color.red);
			
		} else if  (e.getSource() == btSair ) {
			t01.windowClosing(null);			
		}
		
	}

	
}


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Exemplo_04_ActionListener{
	public static void main(String argumentos[]){
		Janela jan = new Janela(); 
		TratEventosJan trat = new TratEventosJan();
		jan.addWindowListener(trat);
		TratEventosAction trat_action = new TratEventosAction();
		jan.btnFechar.addActionListener(trat_action);
		jan.btSair.addActionListener(trat_action);
		jan.btnOk.addActionListener(trat_action);
		jan.btQualquer.addActionListener(trat_action);
		jan.btPokemon.addActionListener(trat_action);
		jan.setVisible(true);
		
	}
}

class Janela extends JFrame{
	JButton btnFechar = new JButton("Fechar");
	JButton btnOk = new JButton("Ok");
	JButton btQualquer = new JButton("Qualquer");
	JButton btPokemon = new JButton("Pokemon");
	JButton btSair = new JButton("Sair");
	public Janela(){
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(Color.gray);
		add( new JLabel("Janela da aplicação"));
		add(btnFechar);
		add(btnOk);
		add(btQualquer);
		add(btPokemon);
		add(btSair);

		btnFechar.setActionCommand("fechar");
		btSair.setActionCommand("fechar");
		btnOk.setActionCommand("ok");
		btQualquer.setActionCommand("qualquer");
		btPokemon.setActionCommand("p");
		setSize(500, 300);
	}
}

class TratEventosJan extends WindowAdapter{
	public void windowClosing(WindowEvent evento){
		System.exit(0);
	}
}


class TratEventosAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "fechar") {
			System.exit(0);	
		} else if (arg0.getActionCommand() == "ok") {
			JOptionPane.showMessageDialog(null,"Botão Ok pressionado!!!");
			System.out.print("Botão Ok pressionado!!!");
		}  else if (arg0.getActionCommand() == "qualquer") {
			JOptionPane.showMessageDialog(null,"Botão qualquer pressionado!!!");
			System.out.print("Botão qualquer pressionado!!!");
		}   else if (arg0.getActionCommand() == "p") {
			JOptionPane.showMessageDialog(null,"Botão Pokemon pressionado!!!");
			System.out.print("Botão Pokemon pressionado!!!");
		} 
	}
}


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TelaCadastro extends JFrame implements ActionListener {

	JLabel lblResultado, lblUF;
	ButtonGroup grpSexo;
	JRadioButton rdMasculino, rdFeminino;
	JCheckBox chkPortugues, chkIngles, chkEspanhol, chkAlemao;
	JComboBox comboUF;
	JTextArea txtAreaResultado;
	JPanel painelUF, painelComboRadio, painelSexo, painelLinguas, painelBotoes;
	JButton btOk, btSair;
	JTextField txtNome;
	
	TelaCadastro(){
		this.setTitle("Cadastro");
		this.setLayout(new GridLayout(5,1));
		this.setSize(400, 300);
		
		lblUF = new JLabel("UF");
		String UF[] = {	"AC","AL","AP","AM","BA","CE","DF","ES",
						"GO","MA","MT","MS","MG","PA","PB","PR","PE","PI",
						"RJ","RN","RS","RO","RR","SC","SP","SE","TO"
					};
		comboUF = new JComboBox(UF);
		
		painelUF = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelUF.add(lblUF);
		painelUF.add(comboUF);
		painelUF.add(new JLabel("Nome"));
		
		txtNome = new JTextField(20);
		painelUF.add(txtNome);
		
		String cores[] = {"Azul","Amarero","Vermelho","Branco","Verde"};
			
		lblResultado = new JLabel("Resultado");

		rdMasculino = new JRadioButton("Masculino", true);
		rdFeminino = new JRadioButton("Feminino");
		
		grpSexo = new ButtonGroup();
		grpSexo.add(rdMasculino);
		grpSexo.add(rdFeminino);

		TitledBorder tituloSexo = BorderFactory.createTitledBorder("Sexo");
		TitledBorder tituloLinguas = BorderFactory.createTitledBorder("Linguas");
		 
		chkPortugues = new JCheckBox("Português",true);
		chkIngles = new JCheckBox("Inglês");
		chkEspanhol = new JCheckBox("Espanhol");
		chkAlemao = new JCheckBox("Alemão");
				
		txtAreaResultado = new JTextArea(30,5);
		JScrollPane spResultado = new JScrollPane(txtAreaResultado);
		
		btOk = new JButton("Ok");
		btSair = new JButton("Sair");
			
		painelComboRadio = new JPanel(new GridLayout(1,2));
		
		painelSexo = new JPanel(new GridLayout(2,1));
		painelSexo.setBorder(tituloSexo);
		painelSexo.add(rdMasculino);
		painelSexo.add(rdFeminino);
		
		painelLinguas = new JPanel(new GridLayout(2,2));
		painelLinguas.setBorder(tituloLinguas);
		painelLinguas.add(chkPortugues);
		painelLinguas.add(chkIngles);
		painelLinguas.add(chkEspanhol);
		painelLinguas.add(chkAlemao);
		
		painelComboRadio.add(painelSexo);
		painelComboRadio.add(painelLinguas);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBotoes.add(btOk);
		painelBotoes.add(btSair);

		btOk.addActionListener(this);
		btSair.addActionListener(this);
		
		this.add(painelUF);
		this.add(painelComboRadio);
		this.add(lblResultado);
		this.add(spResultado);
		this.add(painelBotoes);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaCadastro t01 = new TelaCadastro();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSair) {
			System.exit(0);
		} else if (e.getSource() == btOk){
			String resultado="", sexo="", linguas="";
			boolean flagLinguas = false;
			
			sexo = rdMasculino.getText();
			if (rdFeminino.isSelected()) {
				sexo = rdFeminino.getText();
			}
			
			if (chkPortugues.isSelected()) {
				linguas += chkPortugues.getText();
				flagLinguas = true;
			}
			if (chkIngles.isSelected()) {
				linguas += (flagLinguas ? ", ":"") + chkIngles.getText() ;
				flagLinguas = true;
			}
			if (chkEspanhol.isSelected()) {
				linguas += (flagLinguas ? ", ":"") + chkEspanhol.getText();
				flagLinguas = true;
			}
			if (chkAlemao.isSelected()) {
				linguas += (flagLinguas ? ", ":"") + chkAlemao.getText();
			}

			resultado += "UF\t"+comboUF.getSelectedItem()+"\n";
			resultado += "Sexo\t"+	sexo  +"\n";
			resultado += "Linguas\t"+ linguas +"\n";			
			resultado += "Nome\t" + txtNome.getText();
			txtAreaResultado.setText(resultado); 
		}
	}

}

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class EntradaFormatada extends JFrame{


	JLabel lblTelefone, lblCEP, lblPlaca, lblCNPJ, lblCPF, lblData, lblSalario;
	JFormattedTextField txtTelefone, txtCEP, txtPlaca, txtCNPJ, txtCPF, txtData, txtSalario;
	
	EntradaFormatada() throws ParseException{

		this.setTitle("Entrada Formatada");
		this.setLayout(new GridLayout(7,2));
		this.setSize(300, 200);
		this.setResizable(true);
		
		lblTelefone = new JLabel("Telefone");
		lblCEP = new JLabel("CEP");
		lblPlaca = new JLabel("Placa");
		lblCNPJ = new JLabel("CNPJ");
		lblCPF = new JLabel("CPF");
		lblData = new JLabel("Data");
		lblSalario = new JLabel("Salário");
		
		txtTelefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		txtCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		txtCNPJ = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		
	// Data

		DateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter displayFormatter = new DateFormatter(displayFormat);
		DateFormat editFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter editFormatter = new DateFormatter(editFormat);
		DefaultFormatterFactory factoryDate = new DefaultFormatterFactory(displayFormatter,displayFormatter, editFormatter);        
		txtData = new JFormattedTextField(factoryDate, new Date());
		
		// Salario
        txtSalario = new JFormattedTextField();
 
        // Criando formatos, default, display, edit
        NumberFormatter formatoDefault = new NumberFormatter(new DecimalFormat("#.##"));
        NumberFormatter formatoDisplay = new NumberFormatter(new DecimalFormat("R$ #,###.00"));
        NumberFormatter formatoEdit = new NumberFormatter(new DecimalFormat("#.##")); 

        // Criando e configurando DefaultFormatterFactory
        DefaultFormatterFactory salarioFactory = new DefaultFormatterFactory(formatoDefault,formatoDisplay,formatoEdit);
        txtSalario.setFormatterFactory(salarioFactory);
 	
		this.add(lblTelefone);
		this.add(txtTelefone);
		this.add(lblCEP);
		this.add(txtCEP);
		this.add(lblPlaca);
		this.add(txtPlaca);
		this.add(lblCNPJ);
		this.add(txtCNPJ);
		this.add(lblCPF);
		this.add(txtCPF);
		this.add(lblData);
		this.add(txtData);
		this.add(lblSalario);
		this.add(txtSalario);
		
		this.setVisible(true);
			
	}
	
	public static void main(String[] args) throws ParseException {
		EntradaFormatada tela = new EntradaFormatada();

	}

}

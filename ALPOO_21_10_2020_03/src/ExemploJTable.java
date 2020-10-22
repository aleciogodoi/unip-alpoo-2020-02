import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExemploJTable extends JFrame implements ActionListener {
	JTable tabela;
	DefaultTableModel modelo;
	JButton btn;

	public ExemploJTable() {
		String colunas[] = {"Nome", "Endereço", "Telefone", "e-mail"};
		String dados[][] = { 
							{"João", "Rua Tal", "4444","joao@gmail.com"},
							{"Maria", "Av Tal", "3333","maria@gmail.com"},
							{"Pedro", "Av Imperador", "211","pedro@gmail.com"} 
						};
		modelo = new DefaultTableModel(dados, colunas);
		tabela = new JTable(modelo);
		JScrollPane sp = new JScrollPane(tabela);
		add(sp, BorderLayout.NORTH);

		btn = new JButton("Ok");
		btn.addActionListener(this);
		add(btn, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
		int linha = tabela.getSelectedRow();
		int coluna = tabela.getSelectedColumn();
		if (linha != -1 && coluna != -1) {
			String dado = (String)tabela.getValueAt(linha, coluna);
			JOptionPane.showMessageDialog(this, dado);
		} else {
			JOptionPane.showMessageDialog(this, "Sem seleção");
		}
	}

	public static void main(String[] args) {
		new ExemploJTable();
	}
}

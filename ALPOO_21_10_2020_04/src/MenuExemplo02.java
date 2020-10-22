
import java.awt.*;
import java.awt.event.*;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class MenuExemplo02 implements ActionListener, ItemListener {
    JTextArea output;			// Text Area
    JScrollPane scrollPane;		// Painel Scroll
    String novaLinha = "\n";
    
    public JMenuBar criaMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        // Criando a Barra de Menu
        menuBar = new JMenuBar();

        // Primeiro Menu
        menu = new JMenu("Menu");
        menuBar.add(menu);

        // Grupo de Itens de Menu
        menuItem = new JMenuItem("Item Menu");        
        menu.add(menuItem);
        menuItem.addActionListener(this);

        menuItem = new JMenuItem("Outro Item Menu");
        menu.add(menuItem);
        menuItem.addActionListener(this);
   
        //Um Grupo de Radio Button - Items
        menu.addSeparator();	// Separador de Itens
     
        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("Item Radio Button");
        rbMenuItem.setSelected(true);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);   
        rbMenuItem.addActionListener(this);
       
        rbMenuItem = new JRadioButtonMenuItem("Outro Item Radio Button");
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        rbMenuItem.addActionListener(this);

        //Um Grupo de Check Box - Itens
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("Item Check Box");
        menu.add(cbMenuItem);
        cbMenuItem.addActionListener(this);

        cbMenuItem = new JCheckBoxMenuItem("Outro Item Check Box");
        menu.add(cbMenuItem); 
        cbMenuItem.addItemListener(this);
        cbMenuItem.addActionListener(this);

        // Submenu
        menu.addSeparator();
        submenu = new JMenu("Submenu");

        menuItem = new JMenuItem("Item Submenu");
        submenu.add(menuItem);
        menuItem.addActionListener(this);

        menuItem = new JMenuItem("Outro Item Submenu");
        submenu.add(menuItem);
        menu.add(submenu);
        menuItem.addActionListener(this);

        //Criando um segundo Menu
        menu = new JMenu("Segundo Menu");
        menuBar.add(menu);

        //Criando um terceiro Menu
        menu = new JMenu("Terceiro Menu");
        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane() {
        // Criando um Container/Painel
        JPanel contentPane = new JPanel(new BorderLayout());

        // Area de TextArea
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        // Adiciona o TextArea ao scroll
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }


    /**
     * Metodo para criação do menu
     */
    private static void createAndShowGUI() {
        //Criando e configurando a Janela
        JFrame frame = new JFrame("Menu Exemplo 02");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuExemplo02 exemplo = new MenuExemplo02();
        frame.setJMenuBar(exemplo.criaMenuBar());
        frame.setContentPane(exemplo.createContentPane());

        // Mostrando a Janela
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
                createAndShowGUI();
    }

	public void actionPerformed(ActionEvent e) {
	      JMenuItem source = (JMenuItem)(e.getSource());
	        String s = "Evento detectado."
	                   + novaLinha
	                   + "    Origem do evento: " + source.getText();
	        output.append(s + novaLinha);
	}

	public void itemStateChanged(ItemEvent e) {
	      JMenuItem source = (JMenuItem)(e.getSource());
	        String s = "Evento de item detectado.---"
	                   + novaLinha
	                   + "    Evento origem: " + source.getText()
	                   + novaLinha
	                   + "    Novo estado: "
	                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
	                     "selecionado":"não selecionado");
	        output.append(s + novaLinha);	
	}
		
}

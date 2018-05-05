import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Menu  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
		setTitle("Agenda");
		Dimension dimension = new Dimension(500, 300);
		setSize(dimension);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu agenda = new JMenu("Agenda");
		JMenu contato = new JMenu("Contato");
		
		bar.add(agenda);
		bar.add(contato);
		
		JMenuItem novo = new JMenuItem("Novo");
		
        JMenuItem buscar = new JMenuItem("Buscar");
        
        JMenuItem listar = new JMenuItem("Listar");
        
        agenda.add(listar);
        
        contato.add(novo);
        contato.add(buscar);
        
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
         
	}
	
	public static void main(String[] args) {
		new Menu();
	}
	

}

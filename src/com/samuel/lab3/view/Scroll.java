package com.samuel.lab3.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class Scroll extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Container painelPrincipal = getContentPane();
	private JButton botaoSair;
	
	public Scroll(List<String> lista) {
		setSize(500, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation();
		
		JLabel agendaLabel = new JLabel("Agenda telefônica");
		agendaLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
		
		JPanel jPanelTitulo = new JPanel();
		jPanelTitulo.setLayout(new FlowLayout());
		jPanelTitulo.add(agendaLabel);

		getContentPane().add(jPanelTitulo, BorderLayout.NORTH);
		
		JPanel painelAgenda = new JPanel();
		BoxLayout layout = new BoxLayout(painelAgenda, BoxLayout.Y_AXIS);
		painelAgenda.setLayout(layout);
		painelAgenda.setSize(new Dimension(500, 100));

		preencherAgenda(painelAgenda,lista);

		JScrollPane jScrollPane = new JScrollPane(painelAgenda);

		painelPrincipal.add(jScrollPane,BorderLayout.CENTER);
		
		JPanel painelBotao = new JPanel();
		painelBotao.setLayout(new FlowLayout());
		
		botaoSair = new JButton("Sair");
		painelBotao.add(botaoSair);
		
		painelPrincipal.add(painelBotao,BorderLayout.SOUTH);
		
		setClicks();
//		pack();
		setVisible(true);
		
	}

	private void setDefaultCloseOperation() {
		finalizar();
		
	}

	private void setClicks() {
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}

					});
		
	}
	
	private void finalizar() {
		dispose();
	}


	private void preencherAgenda(JPanel painelAgenda, List<String> lista) {
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
		for(String item : lista ) {
			JLabel label = new JLabel(item);
			label.setFont(font);
			painelAgenda.add(label);
		}
			
		
	}
	
	public static void main(String[] args) {
		new Scroll(new ArrayList<String>());
	} 

}

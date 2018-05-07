package com.samuel.lab3.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.samuel.lab3.model.Agenda;
import java.util.List;


public class Menu extends JFrame {

	private final Container painelPrincipal = getContentPane();

	private JMenuItem novo;
	private JMenuItem exibir;
	private JButton botaoSair;
	private JButton botaoAtualizar;

	private Agenda agenda;
	
	
	private Point centro;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu(Agenda agenda) {
		this.agenda = agenda;
		setTitle("Agenda");
		setDefaultCloseOperation();
		setSize(500, 300);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		
		centro = new Point(Integer.valueOf((int) ((scrnsize.getWidth()-getWidth())/2)),Integer.valueOf((int) ((scrnsize.getHeight()-getHeight())/2)));
		
		setLocation(centro);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu contato = new JMenu("Contato");

		bar.add(contato);

		novo = new JMenuItem("Novo");

		exibir = new JMenuItem("exibir");

		contato.add(novo);
		contato.add(exibir);

		JLabel agendaLabel = new JLabel("Agenda telefônica");
		agendaLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 28));

		JPanel jPanelTitulo = new JPanel();
		jPanelTitulo.setLayout(new FlowLayout());
		jPanelTitulo.add(agendaLabel);

		getContentPane().add(jPanelTitulo, BorderLayout.NORTH);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());

		botaoSair = new JButton("Sair");
		botaoAtualizar = new JButton("Atualizar");

		painelBotoes.add(botaoAtualizar);
		painelBotoes.add(botaoSair);

		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

		JPanel painelAgenda = new JPanel();
		BoxLayout layout = new BoxLayout(painelAgenda, BoxLayout.Y_AXIS);
		painelAgenda.setLayout(layout);
		painelAgenda.setSize(new Dimension(500, 100));

		preencherAgenda(painelAgenda);

		JScrollPane jScrollPane = new JScrollPane(painelAgenda);

		painelPrincipal.add(jScrollPane);

		setClicks();		
		setResizable(false);
		setVisible(true);
	}

	private void setDefaultCloseOperation() {
		finalizarFrame();
	}

	private void setClicks() {
		setClickSair();
		setClickNovo();
		setClickExibir();
		setClickAtualizar();

	}

	private void setClickAtualizar() {
		botaoAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarFrame();
				new Menu(agenda);
			}
		});

	}

	private void setClickExibir() {
		
		exibir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcoes = {"Nome","Contato","Nível de amizade"};
				int i  = JOptionPane.showOptionDialog(null, "Exibir por", "Exibir",0, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				if(i==0){
					String nome = JOptionPane.showInputDialog("Digite o nome do contato: ");
					if(nome != null){
						List<String> contatos = agenda.buscaPorNome(nome);
					}
				}
				
			}
		});
		
		
//		exibir.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent event) {
//				String posicao = JOptionPane.showInputDialog(null, "Digite a posição doContato", "Exibir",
//						JOptionPane.QUESTION_MESSAGE);
//				if (posicao != null && posicao.length() > 0) {
//					try {
//						int i = Integer.parseInt(posicao);
//						JOptionPane.showMessageDialog(null, agenda.exibirContato(i), "Contato",
//								JOptionPane.INFORMATION_MESSAGE);
//					} catch (NumberFormatException e) {
//						JOptionPane.showMessageDialog(null, "Você não digitou um número", "Contato",
//								JOptionPane.ERROR_MESSAGE);
//					} catch (RuntimeException e) {
//						JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
//		});
	}

	private void setClickNovo() {
		novo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NovoContato(agenda);
			}
		});

	}

	private void setClickSair() {
		botaoSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarFrame();
			}
		});
	}

	private void finalizarFrame() {
		agenda.persistir();
		this.dispose();
	}

	private void preencherAgenda(JPanel painelAgenda) {
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
		for (int i = 1; i < agenda.getQtd() + 1; i++) {
			try {
				JLabel jLabel = new JLabel("(" + i + ") Contato: " + agenda.exibirNomeContato(i));
				jLabel.setFont(font);
				painelAgenda.add(jLabel);
			} catch (RuntimeException e) {
			}
		}
	}

}

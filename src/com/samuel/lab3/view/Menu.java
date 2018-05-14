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
import com.samuel.lab3.model.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Gráfica utilizada para consumir dados e comando de ações do usuário
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class Menu extends JFrame {

	private final Container painelPrincipal = getContentPane();

	private JMenuItem novo;
	private JMenuItem exibir;
	private JMenuItem listar;
	private JButton botaoSair;
	private JButton botaoAtualizar;
	private JMenuItem qtdPorNivel;
	private JMenuItem mediaAmizade;

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

		centro = new Point(Integer.valueOf((int) ((scrnsize.getWidth() - getWidth()) / 2)),
				Integer.valueOf((int) ((scrnsize.getHeight() - getHeight()) / 2)));

		setLocation(centro);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu contato = new JMenu("Contato");

		bar.add(contato);

		novo = new JMenuItem("Novo");

		exibir = new JMenuItem("exibir");
		
		listar = new JMenuItem("Listar");

		contato.add(novo);
		contato.add(exibir);
		contato.add(listar);

		JMenu outros = new JMenu("Outros");

		qtdPorNivel = new JMenuItem("Amizades por nível");
		mediaAmizade = new JMenuItem("Média de amizades");

		outros.add(qtdPorNivel);
		outros.add(mediaAmizade);

		bar.add(outros);

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
		setClickQtdPorNivel();
		setClickMediaAmizade();
		setClickListar();

	}

	private void setClickListar() {
		listar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Contato[] contatos = agenda.getContatos();
				List<String> lista = new ArrayList<String>();
				for(Contato contato : contatos) {
					if(contato!=null)
						lista.add(contato.toString());
				}
				new Scroll(lista);
				
			}
		});
		
	}

	private void setClickMediaAmizade() {
		mediaAmizade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float media = agenda.mediaAmizade();
				JOptionPane.showMessageDialog(null, "Amédia de amizade da sua agenda é: " + media, "Média",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

	private void setClickQtdPorNivel() {
		qtdPorNivel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] result = capituraNivel();
				if (result != null) {
					int qtdNivel = agenda.quantidadePorNivel((int) result[0]);
					JOptionPane.showMessageDialog(null,
							"A quantidade de contatos pelo nível: " + result[1] + " é: " + qtdNivel,
							"Quantidade por nível", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
	}

	private Object[] capituraNivel() {
		Object[] result = null;
		String[] opcoesNiveis = { "Distante", "Colega", "Amigo", "Amigão", "Irmão" };
		String initialSelection = "Distante";
		boolean sair = false;
		int j = 1;
		do {
			Object nivel = JOptionPane.showInputDialog(null, "Escolha o nível de amizade", "Níveis de amizade",
					JOptionPane.QUESTION_MESSAGE, null, opcoesNiveis, initialSelection);

			if (nivel != null) {
				switch (nivel.toString()) {
				case "Colega":
					j = 2;
					break;
				case "Amigo":
					j = 3;
					break;
				case "Amigão":
					j = 4;
					break;
				case "Irmão":
					j = 5;
					break;
				}
				result = new Object[] { j, nivel.toString() };
				sair = true;
			} else {
				sair = true;
			}
		} while (!sair);
		return result;
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
			public void actionPerformed(ActionEvent event) {
				String[] opcoes = { "Nome", "Contato", "Nível de amizade" };
				int i = JOptionPane.showOptionDialog(null, "Exibir por", "Exibir", 0, JOptionPane.QUESTION_MESSAGE,
						null, opcoes, null);
				if (i == 0) {
					boolean sair = false;
					do {
						String nome = JOptionPane.showInputDialog("Digite o nome do contato: ");
						if (nome == null) {
							sair = true;
						} else if (nome.length() > 0) {
							List<String> contatos = agenda.buscaPorNome(nome);
							if (contatos.isEmpty()) {
								JOptionPane.showMessageDialog(null,
										"Nenhum contato com o nome especificado (" + nome + ")", null,
										JOptionPane.INFORMATION_MESSAGE);
								sair = true;
							} else {
								new Scroll(contatos);
								sair = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Nenhum nome foi especificado", null,
									JOptionPane.INFORMATION_MESSAGE);
						}
					} while (!sair);
				} else if (i == 2) {

					List<String> contatos;

					Object[] result = capituraNivel();
					if (result != null) {
						contatos = agenda.buscaPorNivelAmizade((int) result[0]);
						if (contatos != null && !contatos.isEmpty()) {
							new Scroll(contatos);
						} else {
							JOptionPane.showMessageDialog(null, "Nenhum contato com o nível: " + result[1], "alerta",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				} else if (i == 1) {
					int j = 0;
					boolean sair = false;
					do {
						try {
							String posicao = JOptionPane.showInputDialog("Digite a posição do contato: ");
							if (posicao != null) {
								j = Integer.parseInt(posicao);
								String contato = agenda.exibirContato(j);
								JOptionPane.showMessageDialog(null, contato, "Contato",
										JOptionPane.INFORMATION_MESSAGE);
							}
							sair = true;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Digite um número entre 1 - 100", "Erro",
									JOptionPane.ERROR_MESSAGE);
						} catch (RuntimeException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
					} while (!sair);

				}

			}
		});

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
		for (int i = 1; i < agenda.getTamanho() + 1; i++) {
			try {
				JLabel jLabel = new JLabel("(" + i + ") Contato: " + agenda.exibirNomeContato(i));
				jLabel.setFont(font);
				painelAgenda.add(jLabel);
			} catch (RuntimeException e) {
			}
		}
	}

}

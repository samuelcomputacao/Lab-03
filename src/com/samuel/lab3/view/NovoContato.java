package com.samuel.lab3.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.samuel.lab3.model.Agenda;
import com.samuel.lab3.model.Telefone;


public class NovoContato extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton cancelar;
	private JButton salvar;
	private JComboBox<String> box;
	private JTextField dddField1;
	private JTextField dddField2;
	private JTextField dddField3;
	private JTextField telefoneField1;
	private JTextField telefoneField2;
	private JTextField telefoneField3;
	private JTextField nomeField;
	private JTextField sobrenomeField;
	private JTextField posicaoField;
	
	
	private final Container painelprincipal = getContentPane();
	private Agenda agenda;

	public NovoContato(Agenda agenda) {
		this.agenda = agenda;
		setDefaultCloseOperation();
		setSize(300,350);
		setLayout(new BorderLayout());
		
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		JLabel tituloLabel = new JLabel("Novo Contato");
		tituloLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		titulo.add(tituloLabel);
		
		painelprincipal.add(titulo,BorderLayout.NORTH);
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new FlowLayout());

		Font font = new Font(Font.SERIF, Font.PLAIN, 15);
		
		JPanel painelInicio = new JPanel();
		painelInicio.setLayout(new BorderLayout());
		
		JPanel painelPosicao = new JPanel();
		painelPosicao.setLayout(new FlowLayout());

		JLabel posicao = new JLabel("Posicao:");
		posicao.setFont(font);
		posicaoField = new JTextField(5);
		posicaoField.setFont(font);
		
		painelPosicao.add(posicao);
		painelPosicao.add(posicaoField);
		
		
		JPanel panelNome = new JPanel();
		panelNome.setLayout(new FlowLayout());
		
		JLabel nome = new JLabel("Nome:        ");
		nome.setFont(font);
		nomeField= new JTextField(15);
		nomeField.setFont(font);
		
		panelNome.add(nome);
		panelNome.add(nomeField);
		
		JPanel panelSobrenome = new JPanel();
		panelSobrenome.setLayout(new FlowLayout());
		
		JLabel sobrenome = new JLabel("Sobrenome: ");
		sobrenome.setFont(font);
		sobrenomeField= new JTextField(15);
		sobrenomeField.setFont(font);
		
		panelSobrenome.add(sobrenome);
		panelSobrenome.add(sobrenomeField);
		
		painelInicio.add(painelPosicao,BorderLayout.NORTH);
		painelInicio.add(panelNome,BorderLayout.CENTER);
		painelInicio.add(panelSobrenome,BorderLayout.SOUTH);
		
		formulario.add(painelInicio);
	
		
		JPanel panelTelfones = new JPanel();
		panelTelfones.setLayout(new BorderLayout());
		
		JPanel telefone1 = new JPanel(new FlowLayout());
		JLabel celular = new JLabel("Celular:       ");
		celular.setFont(font);
		dddField1= new JTextField(3);
		dddField1.setFont(font);
		telefoneField1= new JTextField(10	);
		telefoneField1.setFont(font);
		
		telefone1.add(celular);
		telefone1.add(dddField1);
		telefone1.add(telefoneField1);
		
		panelTelfones.add(telefone1,BorderLayout.NORTH);
		
		JPanel telefone2 = new JPanel(new FlowLayout());
		JLabel trabalho = new JLabel("Trabalho:    ");
		trabalho.setFont(font);
		dddField2= new JTextField(3);
		dddField2.setFont(font);
		telefoneField2= new JTextField(10	);
		telefoneField2.setFont(font);
		telefone2.add(trabalho);
		telefone2.add(dddField2);
		telefone2.add(telefoneField2);
		panelTelfones.add(telefone2,BorderLayout.CENTER);
		
		JPanel telefone3 = new JPanel(new FlowLayout());
		JLabel casa = new JLabel("Casa:          ");
		casa.setFont(font);
		dddField3= new JTextField(3);
		dddField3.setFont(font);
		telefoneField3= new JTextField(10	);
		telefoneField3.setFont(font);
		telefone3.add(casa);
		telefone3.add(dddField3);
		telefone3.add(telefoneField3);
		panelTelfones.add(telefone3,BorderLayout.SOUTH);
		
		formulario.add(panelTelfones);
		
		JPanel panelAmizade = new JPanel();
		panelAmizade.setLayout(new BorderLayout());
		
		JLabel nivel = new JLabel("Nível de amizade     ");
		nivel.setFont(font);
		box = new JComboBox<>();
		box.addItem("Distante");
		box.addItem("Colega");
		box.addItem("Amigo");
		box.addItem("Amigão");
		box.addItem("irmão");
		
		panelAmizade.add(nivel,BorderLayout.NORTH);
		panelAmizade.add(box,BorderLayout.CENTER);
		
		formulario.add(panelAmizade);
		
		painelprincipal.add(formulario,BorderLayout.CENTER);
		
		JPanel painelSalvar = new JPanel();
		painelSalvar.setLayout(new FlowLayout());
		
		salvar = new JButton("Salvar");
		salvar.setFont(font);
		
		cancelar = new JButton("Cancelar");
		cancelar.setFont(font);
		
		painelSalvar.add(salvar);
		painelSalvar.add(cancelar);
		
		painelprincipal.add(painelSalvar, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		
		setClicks();
	}

	private void setDefaultCloseOperation() {
		this.finalizarFrame();
		
	}

	private void setClicks() {
		setClickCancelar();
		setClickSalvar();
	}

	private void setClickSalvar() {
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eVENT) {
				int i = 0;
				try {
					i = Integer.parseInt(posicaoField.getText());
					if(i<1 || i>100) {
						erro("POSIÇÃO INVÁLIDA");
						return;
					}
				}catch(NumberFormatException e) {
					erro("POSIÇÃO ESPERA UM NÚMERO 1 - 100");
					return;
				}
				String nome = nomeField.getText();
				if(nome==null || nome.trim().length()==0) {
					erro("CAMPO NOME VAZIO");
					return;
				}
				String sobrenome = sobrenomeField.getText();
				if(sobrenome==null || sobrenome.trim().length()==0) {
					erro("CAMPO SOBRENOME VAZIO");
					return;
				}
				
				Telefone[] telefones = new Telefone[3];
				
				String ddd1 = dddField1.getText();
				String telefone1 = telefoneField1.getText();
				if((ddd1 !=null && ddd1.trim().length()>0)&&(telefone1 !=null && telefone1.trim().length()>0)) {
					telefones[0]= new Telefone(ddd1, telefone1,"CELULAR");
				}
				
				String ddd2 = dddField2.getText();
				String telefone2 = telefoneField2.getText();
				if((ddd2 !=null && ddd2.trim().length()>0)&&(telefone2 !=null && telefone2.trim().length()>0)) {
					telefones[1]= new Telefone(ddd2, telefone2,"TRABALHO");
				}
				
				String ddd3 = dddField3.getText();
				String telefone3 = telefoneField3.getText();
				if((ddd3 !=null && ddd3.trim().length()>0)&&(telefone3 !=null && telefone3.trim().length()>0)) {
					telefones[2]= new Telefone(ddd3, telefone3,"CASA");
				}
				
				if((telefones[0]==null && telefones[1]==null) && telefones[2]==null) {
					erro("NENHUM TELEFONE FOI ADICIONADO");
					return;
				}
				
				int nivel = (int) box.getSelectedIndex();
	
				try {
				 agenda.cadastrarContato(nome, sobrenome, telefones, nivel,i);
				finalizarFrame();
				JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso","", JOptionPane.INFORMATION_MESSAGE);
				 }catch (RuntimeException e) {
					 erro(e.getMessage());
				 }
				 
				 finalizarFrame();
			}
		});
	
	}
	
	private void erro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "erro", JOptionPane.ERROR_MESSAGE);
	}

	private void setClickCancelar() {
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarFrame();
				
			}
		});
		
	}

	private void finalizarFrame() {
		this.dispose();
		
	}

	public static void main(String[] args) {
		new NovoContato(new Agenda());
	}
}

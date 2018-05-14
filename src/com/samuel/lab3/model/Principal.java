package com.samuel.lab3.model;
import java.io.File;

import com.samuel.lab3.view.Menu;

/**
 * Programa responsável por inicializar a interface inicial
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class Principal {
	
	/**
	 * Agenda telefônica do sistema
	 * 
	 */
	private static Agenda agenda;

	/**
	 * Método que inicializa a interface gráfica
	 * @param args
	 */
	public static void main(String[] args){
		agenda = new Agenda();
		File contatos = new File(new File("").getAbsolutePath()+"/file/contatos.json");
		File cadastrados = new File(new File("").getAbsolutePath()+"/file/cadastrados.json");
		agenda.consumirDados(contatos, cadastrados);
		new Menu(agenda);
	}
}

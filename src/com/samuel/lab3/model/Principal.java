package com.samuel.lab3.model;
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
	 */
	private static Agenda agenda;

	/**
	 * Método que inicializa a interface gráfica
	 * @param args
	 */
	public static void main(String[] args){
		agenda = new Agenda();
		new Menu(agenda);
	}
}

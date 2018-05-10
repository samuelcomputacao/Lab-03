package com.samuel.lab3.model;
import com.samuel.lab3.view.Menu;

public class Principal {
	private static Agenda agenda;

	public static void main(String[] args) throws Exception{
		agenda = new Agenda();
		new Menu(agenda);
	}
}

package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.samuel.lab3.model.Agenda;

class AgendaTest {
	
	private Agenda agenda;
	
	@Test
	
	void testListarContato() {
		agenda = new Agenda();
		agenda.cadastrarContato("Samuel", "Vasconcelos", "993318274", 1);
		agenda.cadastrarContato("Maria", "Vasconcelos", "993318275", 2);
		assertEquals("Contato : Samuel Vasconcelos - 993318274"+System.lineSeparator()+"Contato : Maria Vasconcelos - 993318275"+System.lineSeparator(), agenda.listarContato());
	}
	
	@Test
	void testExibirContato() {
		agenda = new Agenda();
		agenda.cadastrarContato("Samuel", "Vasconcelos", "993318274", 1);
		assertEquals("Contato : Samuel Vasconcelos - 993318274", agenda.exibirContato(1));	
	}
	
	@Test
	void testExibirContatoNull() {
		try {
			agenda.exibirContato(23);
			fail("Erro");
		}catch(RuntimeException e) {
			
		}
			
	}

	@Test
	void testExibirContatoMenor() {
		agenda = new Agenda();
		try {
			agenda.exibirContato(0);
			fail("erro");
		}catch (RuntimeException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testExibirContatoMaior() {
		agenda = new Agenda();
		try {
			agenda.exibirContato(101);
			fail("erro");
		}catch (RuntimeException e) {
			// TODO: handle exception
		}
	}

	@Test()
	void testCadastrarContato() {
		agenda = new Agenda();
		agenda.cadastrarContato("Samuel", "Vasconcelos", "993318274", 2);
	}
	
	@Test
	void testCadastrarContatoMenor() {
		try {
			agenda.cadastrarContato("Samuel", "Vasconcelos", "993318274", 0);
			fail("erro");
		}catch(RuntimeException e) {
		}
	}
	
	@Test
	void testCadastrarContatoMaior() {
		try {
			agenda.cadastrarContato("Samuel", "Vasconcelos", "993318274", 101);
			fail("erro");
		}catch(RuntimeException e) {
			
		}
	}

	@Test
	void testPersistir() {
		agenda = new Agenda();
		agenda.persistir();
	}

}

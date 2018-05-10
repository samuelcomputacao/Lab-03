package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.samuel.lab3.model.Agenda;
import com.samuel.lab3.model.Telefone;
import java.util.List;



public class AgendaTest {
	
	private Agenda agenda;

	@Before
	public void testAgenda() {
		agenda = new Agenda();
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "Vasconcelos", telefones,0, 1);
	}
	
	@Test(expected = RuntimeException.class)
	public void testCadastrarContatoAcima() {
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "sobrenome", telefones, 0, 102);
	}
	
	@Test(expected = RuntimeException.class)
	public void testCadastrarContatoAbaixo() {
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "sobrenome", telefones, 0, 0);
	}

	@Test
	public void testListarContato() {
		assertEquals("Contato : Samuel Vasconcelos CASA: (83) 93318274 Nível: Distante"+System.lineSeparator(), agenda.listarContato());
	}

	@Test
	public void testExibirContato() {
		assertEquals("Contato : Samuel Vasconcelos CASA: (83) 93318274 Nível: Distante",agenda.exibirContato(1));
	}

	@Test
	public void testGetTamanho() {
		assertEquals(100, agenda.getTamanho());
	}

	@Test
	public void testExibirNomeContato() {
		assertEquals("Samuel Vasconcelos", agenda.exibirNomeContato(1));
	}

	@Test
	public void testBuscaPorNome() {
		List<String> expected = new ArrayList<String>();
		expected.add(agenda.exibirContato(1));
		
		assertEquals(expected, agenda.buscaPorNome("Samuel"));
	}

	@Test
	public void testBuscaPorNivelAmizade() {
		fail("Not yet implemented");
	}

	@Test
	public void testMediaAmizade() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuantidadePorNivel() {
		assertEquals(1, agenda.quantidadePorNivel(1));
	}

}

package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.samuel.lab3.model.Agenda;
import com.samuel.lab3.model.Telefone;
import java.util.List;


/**
 * Classe responsável por testar os métodos da classe Agenda
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class AgendaTest {
	
	/**
	 * Agenda que será usada para teste
	 */
	private Agenda agenda;
	
	/**
	 * Testa e inicializa a agenda
	 */
	@Before
	public void testAgenda() {
		agenda = new Agenda();
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "Vasconcelos", telefones,1, 1);
	}
	
	/**
	 * Testa o contrutor com indice inválido acima
	 */
	@Test(expected = RuntimeException.class)
	public void testCadastrarContatoAcima() {
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "sobrenome", telefones, 0, 102);
	}
	
	/**
	 * Testa o contrutor com indice inválido abaixo
	 */
	@Test(expected = RuntimeException.class)
	public void testCadastrarContatoAbaixo() {
		Telefone t = new Telefone("83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		agenda.cadastrarContato("Samuel", "sobrenome", telefones, 0, 0);
	}
	
	/**
	 * Testa o método de listagem de contatos da agenda
	 */
	@Test
	public void testListarContato() {
		assertEquals("Contato : Samuel Vasconcelos CASA: (83) 93318274 Nível: Distante"+System.lineSeparator(), agenda.listarContato());
	}

	/**
	 * Testa o método de exibição de um contato da agenda
	 */
	@Test
	public void testExibirContato() {
		assertEquals("Contato : Samuel Vasconcelos CASA: (83) 93318274 Nível: Distante",agenda.exibirContato(1));
	}

	/**
	 * Testa o método que verifica o tamanho da agenda
	 */
	@Test
	public void testGetTamanho() {
		assertEquals(100, agenda.getTamanho());
	}
	
	/**
	 * Testa o método de exibição do nome completo de um contato
	 */
	@Test
	public void testExibirNomeContato() {
		assertEquals("Samuel Vasconcelos", agenda.exibirNomeContato(1));
	}
	
	/**
	 * Testa o método de busca a partir de um nome
	 */
	@Test
	public void testBuscaPorNome() {
		List<String> expected = new ArrayList<String>();
		expected.add(agenda.exibirContato(1));
		
		assertEquals(expected, agenda.buscaPorNome("Samuel"));
	}

	/**
	 * Testa o método de busca a partir de um nível de amizade
	 */
	@Test
	public void testBuscaPorNivelAmizade() {
		List<String> expected = new ArrayList<String>();
		expected.add(agenda.exibirContato(1));
		assertEquals(expected, agenda.buscaPorNivelAmizade(1));
	}

	/**
	 * Testa o método que calcula a média de amizade da agenda
	 */
	@Test
	public void testMediaAmizade() {
		assertTrue(1==agenda.mediaAmizade());
	}
	
	/**
	 * Testa o método que calcula a quantidade de contatos por nível especificado
	 */
	@Test
	public void testQuantidadePorNivel() {
		assertEquals(1, agenda.quantidadePorNivel(1));
	}

}

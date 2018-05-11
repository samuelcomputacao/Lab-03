package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.samuel.lab3.model.Contato;
import com.samuel.lab3.model.Telefone;

/**
 * Classe responsável por testar os métodos ca classe Contato
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class ContatoTest {
	
	/**
	 * Contato que será usado como base para os testes
	 */
	private Contato contato;
	
	/**
	 * Teste reponsável por inicializar o contato base e testar o contrutor
	 */
	@Before
	public void testConstruct() {
		Telefone t = new Telefone("55","83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		contato = new Contato("Samuel", "Vasconcelos", telefones, 5);
	}
	
	/**
	 * Testa o contrutor quando recebe um nome nulo
	 */
	@Test(expected = RuntimeException.class)
	public void testConstructNomeNull() {
		Telefone t = new Telefone("55","83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		contato = new Contato(null, "Vasconcelos", telefones, 5);
	}
	
	/**
	 * Testa o contrutor quando recebe um sobrenome nulo
	 */
	@Test(expected = RuntimeException.class)
	public void testConstructSobrenomeNull() {
		Telefone t = new Telefone("55","83", "93318274", "CASA");
		Telefone[] telefones = {null,t,null};
		contato = new Contato("Samuel", null, telefones, 5);
	}
	
	/**
	 * Testa o contrutor quando não recebe nenhum telefone 
	 */
	@Test(expected = RuntimeException.class)
	public void testConstructTelefoneNull() {
		contato = new Contato("Samuel", "Vasconcelos", null, 5);
	}
	
	/**
	 * Testa o método que cria uma representação para o contato
	 */
	@Test
	public void testToString() {
		assertEquals("Contato : Samuel Vasconcelos CASA: 55 (83) 93318274 Nível: Irmão", contato.toString());
	}

	/**
	 * Testa o método que verifica se dois contatos são iguais
	 */
	@Test
	public void testEquals() {
		Telefone t = new Telefone("55","83", "93318274", "CASA");
		Telefone[] telefones = {null,null,t};
		Contato c = new Contato("Samuel", "José",telefones,5);
		assertTrue(c.equals(contato));
	}

	/**
	 * Testa o método que cria o nome completo para um contato
	 */
	@Test
	public void testNomeCompleto() {
		assertEquals("Samuel Vasconcelos", contato.nomeCompleto());;
	}

	/**
	 * Testa o método que retorna o nome do contato
	 */
	@Test
	public void testGetNome() {
		assertEquals("Samuel", contato.getNome());
	}
	
	/**
	 * Testa o método que retorna o nível do contato
	 */
	@Test
	public void testGetNivel() {
		assertTrue(5==contato.getNivel());
	}

}

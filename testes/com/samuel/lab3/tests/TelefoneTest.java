package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.samuel.lab3.model.Telefone;

/**
 * Classe responsável por testar os métodos da classe Telefone
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class TelefoneTest {
	
	/**
	 * Telefone utilizado com base para os testes
	 */
	private Telefone telefone;

	/**
	 * Teste responsável por inicializar  e testar o contrutor de telefone
	 */
	@Before
	public void testTelefone() {
		telefone = new Telefone("83", "993318274", "CASA");
	}
	
	/**
	 * Testa o construtor quando recebe um dd nulo
	 */
	@Test(expected = RuntimeException.class)
	public void testTelefoneDddNull() {
		telefone = new Telefone(null, "993318274", "CASA");
	}
	
	/**
	 * Testa o construtor quando recebe o número nulo
	 */
	@Test(expected = RuntimeException.class)
	public void testTelefoneNumeroNull() {
		telefone = new Telefone("83", null, "CASA");
	}

	/**
	 * Testa o construtor quando recebe a categoria nula
	 */
	@Test(expected = RuntimeException.class)
	public void testTelefoneCategoriaNull() {
		telefone = new Telefone("83", "993318274", null);
	}
	
	/**
	 * Testa o método que cria uma representação de telefone
	 */
	@Test
	public void testToString() {
		assertEquals("CASA: (83) 993318274", telefone.toString());
	}

}

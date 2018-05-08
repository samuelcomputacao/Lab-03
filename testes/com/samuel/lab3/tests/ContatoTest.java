package com.samuel.lab3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.samuel.lab3.model.Contato;
import com.samuel.lab3.model.Telefone;

public class ContatoTest {
	
	private Contato c;

	@Test
	public void testContato() {
		c = new Contato("Samuel", "Vasconcelos", "993318274");
	}
	
	@Test
	public void testContatoNomeNulo() {
		try {
			c = new Contato(null, "Vasconcelos", "993318274");
			fail("erro");
		}catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void testContatoSobrenomeNulo() {
		try {
			c = new Contato("Samuel", null, "993318274");
			fail("erro");
		}catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void testContatoTelefoneNulo() {
		try {
			c = new Contato("Samuel", "Vasconcelos", null);
			fail("erro");
		}catch (RuntimeException e) {
		}
	}

	@Test
	public void testToString() {
		Telefone[] telefones = {null,new Telefone("83", "993318274", "CASA"),null};
		c = new Contato("Samuel", "Vasconcelos", telefones,1);
		assertEquals("Contato : Samuel Vasconcelos CASA: (83) 993318274 Nível: Colega", c.toString());
	}

}

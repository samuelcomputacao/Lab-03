package com.samuel.lab3.tests;
import static org.junit.jupiter.api.Assertions.*;


import com.samuel.lab3.model.Contato;
class ContatoTest {

	@Test
	void testContato() {
		new Contato("Samuel", "Vasconcelos", "993318274");
	}
	
	@Test
	void testContatoNomeNulo() {
		try {
			new Contato(null, "Vasconcelos", "993318274");
			fail("erro");
		}catch (RuntimeException e) {
			
		}
	}
	
	@Test
	void testContatoSobrenomeNulo() {
		try {
			new Contato("Samuel", null, "993318274");
			fail("erro");
		}catch (RuntimeException e) {
			
		}
	}
	
	@Test
	void testContatoTelefoneNulo() {
		try {
			new Contato("Samuel", "Vasconcelos", null);
			fail("erro");
		}catch (RuntimeException e) {
		}
	}

	@Test
	void testToString() {
		Contato contato = new Contato("Samuel", "Vasconcelos", "993318274");
		assertEquals("Contato : Samuel Vasconcelos - 993318274", contato.toString());
	}

}

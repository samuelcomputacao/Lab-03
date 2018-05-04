

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteAngenda {

	
	@Test
	public void testNewAgenda() {
		new Agenda();
	}
	

	@Test
	public void testCadastraContato() {
		Agenda agenda  = new Agenda();
		assertTrue(agenda.cadastrarContato("samuel", "vasconcelos", "12345678", 1));
		assertTrue(agenda.cadastrarContato("samuel", "vasconcelos", "12345678", 100));
		assertFalse(agenda.cadastrarContato("samuel", "vasconcelos", "12345678", 0));
		assertFalse(agenda.cadastrarContato("samuel", "vasconcelos", "12345678", 101));
		
	}

}

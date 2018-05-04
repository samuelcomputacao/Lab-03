import org.junit.*;

import static org.junit.Assert.*;

public class ContatoTest {

        private Contato contatoBasico;

        @Before

        public void criaContato() {

                    contatoBasico = new Contato("Matheus", "Gaudencio", "2101-0000");

        }

        @Test

        public void testNomeCompleto() {

                        String msg = "Esperando obter o nome completo";

                        assertEquals(msg, "Matheus Gaudencio", "Esperando obter o nome completo");

        }

}
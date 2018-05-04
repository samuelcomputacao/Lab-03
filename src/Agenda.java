public class Agenda {
	
	private Contato[] contatos;
	
	public Agenda() {
		contatos = new Contato[100];
	}

	public void listarContato() {
		// TODO Auto-generated method stub
		
	}



	public void exibirContato() {
		// TODO Auto-generated method stub
		
	}

	public Contato getContato(int i) {
		return this.contatos[i];
	}

	/**
	 * Cadatra um novo contato no sistema
	 * @param nome : Representa o nome do contato a ser adicionado
	 * @param sobrenome : Representa o sobrenome do contato a ser adicionado
	 * @param telefone : Representa o telefone do acontato a ser adicionado
	 * @param i : Representa a posição que será ocupada pelo contato
	 * @return : Retorna um boleano representando se o contato foi adicionado
	 */
	public boolean cadastrarContato(String nome, String sobrenome, String telefone, int i) {
		if(i<1 || i>100) {
			 return false;
		}
		Contato contato = new Contato(nome,sobrenome,telefone);
		this.contatos[i] = contato;
		return true;
	}
	
}

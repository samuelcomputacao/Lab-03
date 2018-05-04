
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Contato : "+ this.nome + " "+ this.sobrenome + " - "+ this.telefone;
	}
	
}

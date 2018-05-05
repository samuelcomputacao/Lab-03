public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato(String nome, String sobrenome, String telefone) {
		if(nome == null || nome.length()==0) throw new RuntimeException("NOME OBRIGATÓRIO!");
		if(sobrenome == null || sobrenome.length()==0) throw new RuntimeException("SOBRENOME OBRIGATÓRIO!");
		if(telefone == null || telefone.length()==0) throw new RuntimeException("TELEFONE OBRIGATÓRIO!");
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Contato : "+ this.nome + " "+ this.sobrenome + " - "+ this.telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}

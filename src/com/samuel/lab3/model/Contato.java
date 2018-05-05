package com.samuel.lab3.model;
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private Telefone[] telefones;
	private int nivel;
	
	public Contato(String nome, String sobrenome, String telefone) {
		if(nome == null || nome.length()==0) throw new RuntimeException("NOME OBRIGATÓRIO!");
		if(sobrenome == null || sobrenome.length()==0) throw new RuntimeException("SOBRENOME OBRIGATÓRIO!");
		if(telefone == null || telefone.length()==0) throw new RuntimeException("TELEFONE OBRIGATÓRIO!");
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	public Contato(String nome, String sobrenome, Telefone[] telefones,int nivel) {
		if(nome == null || nome.length()==0) throw new RuntimeException("NOME OBRIGATÓRIO!");
		if(sobrenome == null || sobrenome.length()==0) throw new RuntimeException("SOBRENOME OBRIGATÓRIO!");
		if(telefones == null || telefones.length==0) throw new RuntimeException("É OBRIGATÓRIO AO MENOS UM TELEFONE!");
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = telefones;
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		String telefones = "";
		if(this.telefones!=null)
		for(int i = 0;i<this.telefones.length;i++) {
			if(this.telefones[i]!=null)
			telefones += this.telefones[i].toString()+" ";
		}
		return "Contato : "+ this.nome + " "+ this.sobrenome + " - "+telefones+" Nível: "+this.nivelString(this.nivel);
	}
	private String nivelString(int nivel) {
		switch (nivel) {
		case 0:
			return "Distante";
		case 1:
			return "Colega";
		case 2:
			return "Amigo";
		case 3:
			return "Amigão";
		case 4:
			return "Irmão";
		}
		return null;
		
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
	public String nomeCompleto() {
		return this.nome+" "+this.sobrenome;
	}
	
	
	
}

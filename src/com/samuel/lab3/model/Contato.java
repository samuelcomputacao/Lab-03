package com.samuel.lab3.model;

/**
 * Classe que representa um contato na agenda
 *  
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class Contato {
	
	/**
	 * Nome do contato
	 */
	private String nome;
	/**
	 * Sobrenome do contato
	 */
	private String sobrenome;
	/**
	 * Telefones do contato
	 */
	private Telefone[] telefones;
	
	/**
	 * Nível de amizade do contato
	 */
	private int nivel;
	
	/**
	 * Construtor responsável por inicializar o contato na memória
	 * @param nome : Representa o nome do contato
	 * @param sobrenome : Representa o sobrenome do contato 
	 * @param telefones : Representa os telefones do contato
	 * @param nivel : Represenat o nível de amizade do contato
	 */
	public Contato(String nome, String sobrenome, Telefone[] telefones,int nivel) {
		if(nome == null || nome.length()==0) throw new RuntimeException("NOME OBRIGATÓRIO!");
		if(sobrenome == null || sobrenome.length()==0) throw new RuntimeException("SOBRENOME OBRIGATÓRIO!");
		if(telefones == null || telefones.length==0) throw new RuntimeException("É OBRIGATÓRIO AO MENOS UM TELEFONE!");
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = telefones;
		this.nivel = nivel;
	}
	
	/**
	 * Método responsável por derar uma string que representa um contato 
	 * @return Uma String representando o contato
	 */
	@Override
	public String toString() {
		String telefones = "";
		if(this.telefones!=null)
		for(int i = 0;i<this.telefones.length;i++) {
			if(this.telefones[i]!=null)
			telefones += " "+this.telefones[i].toString();
		}
		return "Contato : "+ this.nome + " "+ this.sobrenome +telefones+" Nível: "+this.nivelString(this.nivel);
	}
	
	/**
	 * Método responsável por vefificar a qual nível o contato pertence
	 * @param nivel : um inteiro representando o nível
	 * @return Uma representação em String do nível do contato
	 */
	private String nivelString(int nivel) {
		switch (nivel) {
		case 1:
			return "Distante";
		case 2:
			return "Colega";
		case 3:
			return "Amigo";
		case 4:
			return "Amigão";
		case 5:
			return "Irmão";
		}
		return null;
		
	}
	
	/**
	 * Método reponsavel por comparar dois contatos pelo nome
	 * @return retorna p resultado da comparação entre o nomes dos contatos
	 */
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
	
	/**
	 * Método responsável por criar o nome completo do contato
	 * @return Uma String representando O nome completo do contato
	 */ 
	public String nomeCompleto() {
		return this.nome+" "+this.sobrenome;
	}
	
	/**
	 * @return Uma String representando o nome do contato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return Um inteiro representando o nível de amizade do contato
	 */
	public int getNivel() {
		return this.nivel;
	}
}

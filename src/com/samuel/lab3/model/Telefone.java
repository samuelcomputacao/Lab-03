package com.samuel.lab3.model;


/**
 * Classe que representa um telefone
 * 
 * @author Samuel Pereira de VAsconcelos 
 *
 */
public class Telefone {
	
	/**
	 * Código do país
	 */
	private String cod;
	
	/**
	 * ddd do telefone
	 */
	private String ddd;
	
	/**
	 * Número do telefone
	 */
	private String numero;
	
	/**
	 * Categoria do telefone
	 */
	private String categoria;
	
	/**
	 * Método responsável por inicializar um telefone na memória
	 * @param ddd : Representa o ss do telefone
	 * @param numero : Representa O número do telefone
	 * @param categoria : Representa a cetegaria do telefone
	 */
	public Telefone(String cod,String ddd,String numero, String categoria) {
		if(cod==null) throw new RuntimeException("CAMPO CODIGO PAÍS INVÀLIDO");
		this.cod = cod;
		if(ddd==null) throw new RuntimeException("CAMPO DDD INVÁLIDO");
		this.ddd = ddd;
		if(numero==null) throw new RuntimeException("CAMPO NUMERO INVÁLIDO");
		this.numero = numero;
		if(categoria==null) throw new RuntimeException("CAMPO CATEGORIA INVÁLIDO");
		this.categoria = categoria;
	}
	
	/**
	 * Método responsável por criar uma representação para um telefone
	 */
	@Override
	public String toString() {
		return this.categoria+": "+this.cod+" ("+this.ddd+") "+this.numero;
	}

}

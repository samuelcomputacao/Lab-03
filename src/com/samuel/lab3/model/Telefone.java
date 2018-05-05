package com.samuel.lab3.model;

public class Telefone {
	
	private String ddd;
	private String numero;
	private String categoria;
	
	public Telefone(String ddd,String numero, String categoria) {
		this.ddd = ddd;
		this.numero = numero;
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return this.categoria+": ("+this.ddd+") "+this.numero;
	}

}

package com.samuel.lab3.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

public class Agenda {
	
	private Contato[] contatos;
	
	public Agenda() {
	
		Gson gson =new Gson() ;
		try {
			File file = new File(new File("").getAbsolutePath()+"/file/contatos.json");
			if(file.exists()) {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				this.contatos = gson.fromJson(bufferedReader,Contato[].class);
				if(this.contatos==null) {
					this.contatos = new Contato[100];
				}
			}else {
				contatos = new Contato[100];
			}
		} catch (FileNotFoundException e) {
			
		}
		
	}

	public String listarContato() {
		String retorno = "";
		if(this.contatos!=null) {
			for(int i = 0; i< 100; i++) {
				if(this.contatos[i] != null) {
					retorno += this.contatos[i] + System.lineSeparator();
				}
			}
		}
		return retorno;
	}

	public String exibirContato(int i) {
		if(i<1 || i>100) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		if(this.contatos[i-1]==null) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		return this.contatos[i-1].toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
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
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
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
			 throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		Contato contato = new Contato(nome,sobrenome,telefone);
		this.contatos[i-1] = contato;
		return true;
	}
	public boolean cadastrarContato(String nome, String sobrenome, Telefone[] telefones,int nivel,int i) {
		if(i<1 || i>100) {
			 throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		Contato contato = new Contato(nome,sobrenome,telefones,nivel);
		this.contatos[i-1] = contato;
		return true;
	}

	public void persistir() {
		if(this.contatos!=null) {
			Gson gson = new Gson();
			try {
				File file = new File(new File("").getAbsolutePath()+"/file/contatos.json");
				FileWriter fileWrite = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
				bufferedWriter.write(gson.toJson(this.contatos));
				bufferedWriter.close();
				fileWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getQtd() {
		return this.contatos.length;
	}

	public String exibirNomeContato(int i) {
		if(i<1 || i>100) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		if(this.contatos[i-1]==null) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		return this.contatos[i-1].nomeCompleto();
	}
}

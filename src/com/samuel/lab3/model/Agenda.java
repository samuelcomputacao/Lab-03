package com.samuel.lab3.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
/**
 * Essa é a classe mais importante. Ela é responsável por todas as funcionalidades do sistema.
 * 
 * @author Samuel Pereira de Vasconcelos
 *
 */
public class Agenda {
	
	/**
	 * Array onde são salvos os contatos quando o programa esta em execução
	 */
	private Contato[] contatos;
	
	/**
	 * Número de contatos cadastrado no sistema
	 */
	private int cadastrados;

	/**
	 * Construtor da agenda. Ele consome dados de um arquivo onde é salvo os contatos toda vez que o programa é finalizado.
	 */
	public Agenda() {
		Gson gson = new Gson();
		try {
			File file = new File(new File("").getAbsolutePath() + "/file/contatos.json");
			if (file.exists()) {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				this.contatos = gson.fromJson(bufferedReader, Contato[].class);
				if (this.contatos == null) {
					this.contatos = new Contato[100];
				}

			} else {
				contatos = new Contato[100];
			}
			File file1 = new File(new File("").getAbsolutePath() + "/file/cadastrados.json");
			if (file1.exists()) {
				FileReader fileReader1 = new FileReader(file1);
				BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
				this.cadastrados = gson.fromJson(bufferedReader1, Integer.class);
			}else {
				this.cadastrados = 0;
			}

		} catch (FileNotFoundException e) {

		}

	}

	/**
	 * Método responsável por listar todos os contatos que estão cadastrados 
	 * @return Uma String representando a lista de contatos
	 */
	public String listarContato() {
		String retorno = "";
		if (this.contatos != null) {
			for (int i = 0; i < 100; i++) {
				if (this.contatos[i] != null) {
					retorno += this.contatos[i] + System.lineSeparator();
				}
			}
		}
		return retorno;
	}

	/**
	 * Exibe apenas um contato a partir de uma posição recebida.
	 * @param i : Um inteiro representando a posição que deseja ser buscada
	 * @return Uma String representando o contato
	 */
	public String exibirContato(int i) {
		if (i < 1 || i > 100) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		if (this.contatos[i - 1] == null) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		return this.contatos[i - 1].toString();
	}

	
	/**
	 * Método Equals que verifica apenas se os nomes são iguais
	 */
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
	 * 
	 * @param nome: Representa o nome do contato a ser adicionado
	 * @param sobrenome: Representa o sobrenome do contato a ser adicionado
	 * @param telefones: Representa os telefones do acontato a ser adicionado
	 * @param i: Representa a posição que será ocupada pelo contato
	 * @return : Retorna um boleano representando se o contato foi adicionado
	 */
	public boolean cadastrarContato(String nome, String sobrenome, Telefone[] telefones, int nivel, int i) {
		if (i < 1 || i > 100) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		Contato contato = new Contato(nome, sobrenome, telefones, nivel);
		this.contatos[i - 1] = contato;
		this.cadastrados++;
		return true;
	}

	/**
	 * Método responsável por persistir os contatos em arquivo quando o sistema vai ser encerrado
	 */
	public void persistir() {
		if (this.contatos != null) {
			Gson gson = new Gson();
			try {
				File file = new File(new File("").getAbsolutePath() + "/file/contatos.json");
				FileWriter fileWrite = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);

				bufferedWriter.write(gson.toJson(this.contatos));
				bufferedWriter.close();
				fileWrite.close();

				File file1 = new File(new File("").getAbsolutePath() + "/file/cadastrados.json");
				FileWriter fileWrite1 = new FileWriter(file1);
				BufferedWriter bufferedWriter1 = new BufferedWriter(fileWrite1);

				bufferedWriter1.write(gson.toJson(this.cadastrados));
				bufferedWriter1.close();
				fileWrite1.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método responsável por exibir o nome completo de um contato 
	 * @param i : Representa a posição do contato que se deseja imprimir seu nome completo
	 * @return Uma String representando o nome completo do contato
	 */
	public String exibirNomeContato(int i) {
		if (i < 1 || i > 100) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		if (this.contatos[i - 1] == null) {
			throw new RuntimeException("POSIÇÃO INVÁLIDA");
		}
		return this.contatos[i - 1].nomeCompleto();
	}

	/**
	 * Método responsável por buscar todo os contatos com o nome igual ao que foi especificado
	 * @param nome : Nome que será utilizado para encontrar todos igual a ele.
	 * @return Uma lista de String reseprentando todos os contatos com o nome igual ao que foi passado comoparametro
	 */
	public List<String> buscaPorNome(String nome) {
		List<String> retorno = new ArrayList<String>();
		for (Contato contato : this.contatos) {
			if (contato != null && contato.getNome().equals(nome)) {
				retorno.add(contato.toString());
			}
		}
		return retorno;
	}
	
	/**
	 * Método responsável por buscar todo os contatos com o nível igual ao que foi especificado
	 * @param i : Nível que será utilizado para encontrar todos igual a ele
	 * @return Uma lista de String reseprentando todos os contatos com o nível igual ao que foi passado comoparametro
	 */
	public List<String> buscaPorNivelAmizade(int nivel) {
		List<String> retorno = new ArrayList<String>();
		for (Contato c : this.contatos) {
			if (c != null) {
				if (c.getNivel() == nivel) {
					retorno.add(c.toString());
				}
			}
		}
		return retorno;
	}
	
	/**
	 * Método responsável por calcular a média de amizade da agenda
	 * @return Um float que representa a média de amizade da agenda
	 */
	public float mediaAmizade() {
		int cont = 0;
		if (this.cadastrados != 0) {

			cont += this.quantidadePorNivel(1) * 1;
			cont += this.quantidadePorNivel(2) * 2;
			cont += this.quantidadePorNivel(3) * 3;
			cont += this.quantidadePorNivel(4) * 4;
			cont += this.quantidadePorNivel(4) * 5;
		}
		return cont;
	}

	/**
	 * Método reponsável por calcular quantos contatos há com o mesmo nível que foi especificado
	 * @param nivel : Nível que será usado para verificar quantos há igual a ele
	 * @return Um int representando a quantidade de contatos com o mesmo nível do parâmetro
	 */
	public int quantidadePorNivel(int nivel) {
		int cont = 0;
		for (Contato contato : this.contatos) {
			if (contato != null && contato.getNivel() == nivel)
				cont++;
		}
		return cont;
	}
	
	/**
	 * Método responsável por retornar o tamanho da agenda
	 * @return um int representando o tamanho da agenda
	 */
	public int getTamanho() {
		return this.contatos.length;
	}
}

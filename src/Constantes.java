public enum Constantes {
	
	CADASTRAR("C"),LISTAR("L"),EXIBIR("E"),SAIR("S"),INVALIDA("OPÇÃO INVÁLIDA!"),POSICAO_I("POSIÇÃO INVALIDA"),CADASTRADO("CADASTRO REALIZADO!"),INEXISTENTE("CONTATO INEXISTENTE");
	
	private final String valor;

	
	Constantes(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}

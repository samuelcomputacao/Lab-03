import java.util.Scanner;

public class Principal {
	
	
	private static Agenda agenda;
	private static Scanner scan;

	private static final String SAIR = "S";
	private static final String CADASTRAR = "C";
	private static final String EXIBIR = "E";
	private static final String LISTAR = "L";

	public static void main(String[] args) throws Exception{
		agenda = new Agenda();
		scan = new Scanner(System.in);
		boolean continua = true;
		while (continua) {
			String acao = exibirMenu();

			switch (acao) {
			case SAIR:
				agenda.persistir();
				continua = false;
				break;
			case CADASTRAR:
				try {
					if (criaContato()) {
						System.out.println("CONTATO CADASTRADO");
					}
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case EXIBIR:
				int i = pegaPosicao();
				if (i != -1)
					try {
						System.out.println(agenda.exibirContato(i));
					}catch(RuntimeException e) {
						System.out.println(e.getMessage());
					}
				break;
			case LISTAR:
				System.out.println(agenda.listarContato());
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!!");
			}
		}
		scan.close();
	}

	private static int pegaPosicao() {
		try {
			System.out.print("Contato> ");
			int i = Integer.parseInt(scan.nextLine());
			if (i < 1 || i > 100) {
				System.out.println("POSIÇÃO INVÁLIDA!!");
				return -1;
			}
			return i;
		} catch (NumberFormatException e) {
			System.out.println("DIGITE UM NÚMERO DE 1 A 100");
			return -1;
		}
	}

	private static boolean criaContato() {
		int i = 0;
		String erro = "";
		System.out.print("Posição: ");
		try {
			i = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return false;
		}
		if (i < 0 || i > 100) {
			erro += "POSIÇÃO INVÁLIDA!!" + System.lineSeparator();
		}

		System.out.print("Nome: ");
		String nome = scan.nextLine();

		if (nome == null || nome.length() == 0) {
			erro += "CAMPO NOME NECESSÁRIO!!" + System.lineSeparator();
		}

		System.out.print("Sobrenome: ");
		String sobrenome = scan.nextLine();

		if (sobrenome == null || sobrenome.length() == 0) {
			erro += "CAMPO SOBRENOME NECESSÁRIO!!" + System.lineSeparator();
		}

		System.out.print("Telefone: ");
		String telefone = scan.nextLine();

		if (telefone == null || telefone.length() == 0) {
			erro += "CAMPO TELEFONE NECESSÁRIO!!" + System.lineSeparator();
		}
		if (erro.length() > 0) {
			System.out.println(erro);
			return false;
		}

		try {
			return agenda.cadastrarContato(nome, sobrenome, telefone, i);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static String exibirMenu() {
		System.out.println("--------AGENDA---------");
		System.out.println("| (C)adastrar Contato |");
		System.out.println("| (L)istar Contatos   |");
		System.out.println("| (E)xibir Contato    |");
		System.out.println("| (S)air              |");
		System.out.println("-----------------------\n");
		System.out.print("Opção> ");
		String opcao = scan.nextLine();
		return opcao;
	}

}

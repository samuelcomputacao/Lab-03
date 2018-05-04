import java.util.Scanner;

public class Principal {
	
	private static Agenda agenda = new Agenda();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean continua = true;
	
		
		while(continua) {
			String acao = exibirMenu();
			if(acao.equals(Constantes.SAIR.getValor())) {
				continua = false;
			}else if(acao.equals(Constantes.CADASTRAR.getValor())) {
				boolean criar =  criaContato();
				if(criar) {
					System.out.println(Constantes.CADASTRADO.getValor());
				}else {
					System.out.println(Constantes.POSICAO_I.getValor());
					
				}
			}else if(acao.equals(Constantes.LISTAR.getValor())) {
				agenda.listarContato();
			}else if(acao.equals(Constantes.EXIBIR.getValor())) {
				int i = pegaPosicao();
				if(i != -1) {
					Contato contato = agenda.getContato(i);
					if(contato != null) {
						System.out.println(contato);
					}else {
						System.out.println(Constantes.INEXISTENTE);
					}
				}else {
					System.out.println(Constantes.POSICAO_I.getValor());
				}
				
			}else {
				System.out.println("\n"+Constantes.INVALIDA.getValor()+"\n\n");
			}
		}
		scan.close();
		
	}
	
	
	private static int pegaPosicao() {
		System.out.print("Contato> ");
		int i = Integer.parseInt(scan.nextLine());
		if (i<1 || i >100) {
			return -1;
		}
		return i;
		
	}


	private static boolean criaContato() {
		
		System.out.print("Posição: ");
		int i = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = scan.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = scan.nextLine();
		return agenda.cadastrarContato(nome, sobrenome,telefone,i);
		
	}
	
	private  static String exibirMenu() {
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

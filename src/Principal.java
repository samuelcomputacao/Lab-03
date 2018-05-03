import java.util.Scanner;

public class Principal {
	
	private static Agenda agenda = new Agenda();
	
	public static void main(String[] args) {
		
		boolean continua = true;
	
		
		while(continua) {
			String acao = Agenda.exibirMenu();
			if(acao.equals(Constantes.SAIR.getValor())) {
				continua = false;
			}else if(acao.equals(Constantes.CADASTRAR.getValor())) {
				Object[] retorno = criaContato();
				if(retorno==null) {
					System.out.println(Constantes.POSICAO_I.getValor());
				}else {
					agenda.cadastrarContato((Contato) retorno[0], (int) retorno[1]);
					System.out.println(Constantes.CADASTRADO.getValor());
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
		
	}
	
	
	private static int pegaPosicao() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Contato> ");
		int i = Integer.parseInt(scan.nextLine());
		if (i<1 || i >100) return -1;
		return i;
		
	}


	private static Object[] criaContato() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Posição: ");
		int i = Integer.parseInt(scan.nextLine());
		if(i<1 || i>100) {
			 return null;
		}
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = scan.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = scan.nextLine();
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setSobreNome(sobrenome);
		contato.setTelefone(telefone);
		
		Object[] retorno  = {contato,i};
		
		return retorno;
	}


}

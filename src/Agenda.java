import java.util.Scanner;

public class Agenda {
	
	private Contato[] contatos;
	
	public Agenda() {
		contatos = new Contato[100];
	}

	public  static String exibirMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------AGENDA---------");
		System.out.println("| (C)adastrar Contato |");
		System.out.println("| (L)istar Contatos   |");
		System.out.println("| (E)xibir Contato    |");
		System.out.println("| (S)air              |");
		System.out.println("-----------------------\n");
		System.out.print("Opção> ");
		return scan.nextLine();
	}



	public void cadastrarContato(String[] data, int posicao) {
		this.contatos[posicao] = contato;
	}


	public void listarContato() {
		// TODO Auto-generated method stub
		
	}



	public void exibirContato() {
		// TODO Auto-generated method stub
		
	}

	public Contato getContato(int i) {
		return this.contatos[i];
	}
	
}

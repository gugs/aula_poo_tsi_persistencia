package bancario.tsi;

import java.util.Scanner;

import persistencia.PersistenciaArquivo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersistenciaArquivo pa = new PersistenciaArquivo();
		Scanner sc = new Scanner(System.in);
		
		boolean sair = true;
		int opcao = 0;
		
		
		while(sair) {
			System.out.println("Escolha uma opção:\n1) Cadastrar um cliente;\n2) Sair");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				String nome = "";
				String cpf = "";
				System.out.println("Insira o nome do cliente: ");
				nome = sc.next();
				System.out.println("Insira o CPF: ");
				cpf = sc.next();
				Cliente cli = new Cliente(cpf, nome);
				pa.cadastrarCliente(cli);	
				break;
			case 2:
				sair = false;
				break;
			default:
				break;
			}
		}
	}

}

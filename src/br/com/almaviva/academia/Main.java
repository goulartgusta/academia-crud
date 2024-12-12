package br.com.almaviva.academia;

import br.com.almaviva.academia.controller.AcademiaController;
import br.com.almaviva.academia.model.Academia;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AcademiaController controller = new AcademiaController();

		while (true) {
			System.out.println("\n--- AlmavivaPass ---");
			System.out.println("Bem-vindo(a) ao GymPass da AlmavivA!");
			System.out.println("1. Criar Academia");
			System.out.println("2. Listar Academias");
			System.out.println("3. Atualizar Academia");
			System.out.println("4. Remover Academia");
			System.out.println("5. Sair");
			System.out.print("Por favor, escolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.print("Telefone: ");
				String telefone = scanner.nextLine();
				System.out.print("Sede Principal: ");
				String sede = scanner.nextLine();
				System.out.print("Quantidade de Filiais: ");
				int filiais = scanner.nextInt();
				System.out.print("Plano Mensal: ");
				double plano = scanner.nextDouble();

				controller.criarAcademia(nome, telefone, sede, filiais, plano);
				System.out.println("Academia criada com sucesso!");
				break;
			case 2:
				List<Academia> academias = controller.listarAcademias();
				if (academias.isEmpty()) {
					System.out.println("Nenhuma academia cadastrada.");
				} else {
					for (Academia academia : academias) {
						System.out.println(academia);
					}
				}
				break;
			case 3:
				System.out.print("ID da Academia para atualizar: ");
				int idAtualizar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Novo Nome: ");
				String novoNome = scanner.nextLine();
				System.out.print("Novo Telefone: ");
				String novoTelefone = scanner.nextLine();
				System.out.print("Nova Sede Principal: ");
				String novaSede = scanner.nextLine();
				System.out.print("Nova Quantidade de Filiais: ");
				int novasFiliais = scanner.nextInt();
				System.out.print("Novo Plano Mensal: ");
				double novoPlano = scanner.nextDouble();

				controller.atualizarAcademia(idAtualizar, novoNome, novoTelefone, novaSede, novasFiliais, novoPlano);
				System.out.println("Academia atualizada com sucesso!");
				break;
			case 4:
				System.out.print("ID da Academia para remover: ");
				int idRemover = scanner.nextInt();
				controller.removerAcademia(idRemover);
				System.out.println("Academia removida com sucesso!");
				break;
			case 5:
				System.out.println("Saindo... Volte sempre!");
				scanner.close();
				return;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		}
	}
}
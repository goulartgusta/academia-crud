package br.com.almaviva.academia;

import java.util.Scanner;

import br.com.almaviva.academia.service.AcademiaCreate;
import br.com.almaviva.academia.service.AcademiaDelete;
import br.com.almaviva.academia.service.AcademiaRead;
import br.com.almaviva.academia.service.AcademiaUpdate;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	int opcao = 0;
        while (opcao != 5) {
        	System.out.println();
            System.out.println("Bem-vindo ao AlmavivaPass!");
            
            System.out.println("Menu Principal");
            System.out.println("1. Criar Academia");
            System.out.println("2. Listar Academias");
            System.out.println("3. Atualizar Academia");
            System.out.println("4. Deletar Academia");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    AcademiaCreate.criarAcademia();
                    break;
                case 2:
                    AcademiaRead.listarAcademias();
                    break;
                case 3:
                	AcademiaUpdate.atualizarAcademia();
                    break;
                case 4:
                    AcademiaDelete.deletarAcademia();
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}

package br.com.almaviva.academia.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AcademiaCreate {
    private static final String ACADEMIAS_ARQUIVO = "resources/Academias.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void criarAcademia() {
        System.out.println("Criando uma nova Academia:");

        System.out.print("Nome da Academia: ");
        String nome = sc.nextLine();

        System.out.print("Telefone de contato: ");
        String contato = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Quantidade de Filiais: ");
        int quantidadeDeFiliais = Integer.parseInt(sc.nextLine());

        System.out.print("Plano Mensal R$: ");
        double planoMensal = Double.parseDouble(sc.nextLine());

        int id = criarId();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACADEMIAS_ARQUIVO, true))) {
            writer.write(id + "," + nome + "," + contato + "," + cidade + "," + quantidadeDeFiliais + "," + planoMensal);
            writer.newLine();
            System.out.println("Academia cadastrada!");
            
        } catch (IOException e) {
            System.err.println("Erro ao salvar academia: " + e.getMessage());
        }
    }

    private static int criarId() {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ACADEMIAS_ARQUIVO))) {
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao tentar criar ID: " + e.getMessage());
        }
        return contador + 1; 
    }
}

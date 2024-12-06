package br.com.almaviva.academia.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcademiaUpdate {
    private static final String ACADEMIAS_ARQUIVO = "resources/Academias.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void atualizarAcademia() {
        System.out.print("Por favor, digite o ID da academia que deseja atualizar: ");
        String id = sc.nextLine();

        List<String> academias = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(ACADEMIAS_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals(id)) {
                    encontrado = true;

                    System.out.println("Atualizando a academia com ID " + id + ":");

                    System.out.print("Novo nome (ou pressione Enter para manter): ");
                    String nome = sc.nextLine();
                    if (!nome.isEmpty()) dados[1] = nome;

                    System.out.print("Novo contato (ou pressione Enter para manter): ");
                    String contato = sc.nextLine();
                    if (!contato.isEmpty()) dados[2] = contato;

                    System.out.print("Nova cidade (ou pressione Enter para manter): ");
                    String cidade = sc.nextLine();
                    if (!cidade.isEmpty()) dados[3] = cidade;

                    System.out.print("Nova quantidade de filiais (ou pressione Enter para manter): ");
                    String quantidadeFiliais = sc.nextLine();
                    if (!quantidadeFiliais.isEmpty()) dados[4] = quantidadeFiliais;

                    System.out.print("Novo plano mensal R$ (ou pressione Enter para manter): ");
                    String planoMensal = sc.nextLine();
                    if (!planoMensal.isEmpty()) dados[5] = planoMensal;

                    linha = String.join(",", dados);
                }
                academias.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler academias: " + e.getMessage());
        }

        if (encontrado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACADEMIAS_ARQUIVO))) {
                for (String academia : academias) {
                    writer.write(academia);
                    writer.newLine();
                }
                System.out.println("Academia atualizada com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao salvar atualizações: " + e.getMessage());
            }
        } else {
            System.out.println("Academia com ID " + id + " não encontrada.");
        }
    }
}

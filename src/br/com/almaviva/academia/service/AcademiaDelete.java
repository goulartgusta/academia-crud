package br.com.almaviva.academia.service;


import java.io.*;
import java.util.*;

public class AcademiaDelete {

    private static final String ACADEMIAS_ARQUIVO = "resources/Academias.txt";
    
    private static Scanner sc = new Scanner(System.in);

    public static void deletarAcademia() {
        System.out.print("Por favor, digite o ID da academia que deseja deletar: ");
        String id = sc.nextLine();

        List<String> academias = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(ACADEMIAS_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (!dados[0].equals(id)) {
                    academias.add(linha);
                } else {
                    encontrado = true;
                }
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
                System.out.println("Academia deletada com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao deletar academia: " + e.getMessage());
            }
        } else {
            System.out.println("Academia nao encontrada.");
        }
    }
}


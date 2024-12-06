package br.com.almaviva.academia.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AcademiaRead {
    private static final String ACADEMIAS_ARQUIVO = "resources/Academias.txt";
    
    public static void listarAcademias() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACADEMIAS_ARQUIVO))) {
            String linha;
            System.out.println();
            System.out.println("Academias Cadastradas:");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao listar academias: " + e.getMessage());
        }
    }
}

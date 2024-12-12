package br.com.almaviva.academia.service;

public class Validacoes {
    public static void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
    }

    public static void validarTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("O telefone não pode ser vazio.");
        }
    }

    public static void validarSedePrincipal(String sedePrincipal) {
        if (sedePrincipal == null || sedePrincipal.isBlank()) {
            throw new IllegalArgumentException("A sede principal não pode ser vazia.");
        }
    }

    public static void validarQuantidadeDeFiliais(int quantidadeDeFiliais) {
        if (quantidadeDeFiliais < 0) {
            throw new IllegalArgumentException("A quantidade de filiais deve ser positiva.");
        }
    }

    public static void validarPlanoMensal(double planoMensal) {
        if (planoMensal <= 0) {
            throw new IllegalArgumentException("O plano mensal deve ser maior que zero.");
        }
    }
}
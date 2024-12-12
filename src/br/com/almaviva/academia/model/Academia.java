package br.com.almaviva.academia.model;

public record Academia(int id, String nome, String telefone, String sedePrincipal, int quantidadeDeFiliais,
		double planoMensal) {
}
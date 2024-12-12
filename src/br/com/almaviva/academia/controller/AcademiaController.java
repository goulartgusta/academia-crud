package br.com.almaviva.academia.controller;

import br.com.almaviva.academia.model.Academia;
import br.com.almaviva.academia.service.AcademiaService;
import java.util.*;

public class AcademiaController {
    private final AcademiaService servico = new AcademiaService();

    public void criarAcademia(String nome, String telefone, String sedePrincipal, int quantidadeDeFiliais, double planoMensal) {
        servico.criarAcademia(nome, telefone, sedePrincipal, quantidadeDeFiliais, planoMensal);
    }

    public List<Academia> listarAcademias() {
        return servico.listarAcademias();
    }

    public void atualizarAcademia(int id, String nome, String telefone, String sedePrincipal, int quantidadeDeFiliais, double planoMensal) {
        servico.atualizarAcademia(id, nome, telefone, sedePrincipal, quantidadeDeFiliais, planoMensal);
    }

    public void removerAcademia(int id) {
        servico.removerAcademia(id);
    }
}
package br.com.almaviva.academia.service;

import java.util.List;
import java.util.logging.Logger;

import br.com.almaviva.academia.model.Academia;
import br.com.almaviva.academia.repository.AcademiaRepository;

public class AcademiaService {
    private final AcademiaRepository repositorio = new AcademiaRepository();
    private static final Logger logger = Logger.getLogger(AcademiaService.class.getName());

    public void criarAcademia(String nome, String telefone, String sedePrincipal, int quantidadeDeFiliais, double planoMensal) {
        try {
            Validacoes.validarNome(nome);
            Validacoes.validarTelefone(telefone);
            Validacoes.validarSedePrincipal(sedePrincipal);
            Validacoes.validarQuantidadeDeFiliais(quantidadeDeFiliais);
            Validacoes.validarPlanoMensal(planoMensal);
            repositorio.salvar(new Academia(0, nome, telefone, sedePrincipal, quantidadeDeFiliais, planoMensal));
            logger.info("Academia criada com sucesso.");
        } catch (IllegalArgumentException e) {
            logger.warning("Erro ao criar academia: " + e.getMessage());
        }
    }

    public List<Academia> listarAcademias() {
        return repositorio.buscarAcademias();
    }

    public void atualizarAcademia(int id, String nome, String telefone, String sedePrincipal, int quantidadeDeFiliais, double planoMensal) {
        try {
            Validacoes.validarNome(nome);
            Validacoes.validarTelefone(telefone);
            Validacoes.validarSedePrincipal(sedePrincipal);
            Validacoes.validarQuantidadeDeFiliais(quantidadeDeFiliais);
            Validacoes.validarPlanoMensal(planoMensal);
            repositorio.atualizar(new Academia(id, nome, telefone, sedePrincipal, quantidadeDeFiliais, planoMensal));
            logger.info("Academia atualizada com sucesso.");
        } catch (IllegalArgumentException e) {
            logger.warning("Erro ao atualizar academia: " + e.getMessage());
        }
    }

    public void removerAcademia(int id) {
        repositorio.removerPorId(id);
    }
}
package br.com.almaviva.academia.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.almaviva.academia.model.Academia;

public class AcademiaRepository {
    private static final String ARQUIVO_ACADEMIAS = "resources/Academias.txt";
    private static final Logger logger = Logger.getLogger(AcademiaRepository.class.getName());

    public List<Academia> buscarAcademias() {
        List<Academia> academias = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ACADEMIAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    String[] partes = linha.split(",");
                    if (partes.length != 6) continue; 
                    academias.add(new Academia(
                        Integer.parseInt(partes[0]),
                        partes[1],
                        partes[2],
                        partes[3],
                        Integer.parseInt(partes[4]),
                        Double.parseDouble(partes[5])
                    ));
                } catch (NumberFormatException e) {
                	logger.severe("Linha inválida ignorada: " + linha);
                }
            }
        } catch (IOException e) {
        	logger.severe("Erro ao ler o arquivo: " + e.getMessage());
        }
        return academias;
    }


    public void salvar(Academia academia) {
        List<Academia> academias = buscarAcademias();
        academias.add(new Academia(academias.size() + 1, academia.nome(), academia.telefone(), 
                                    academia.sedePrincipal(), academia.quantidadeDeFiliais(), academia.planoMensal()));
        registrarNoArquivo(academias);
    }

    public void atualizar(Academia academiaAtualizada) {
        List<Academia> academias = buscarAcademias();
        for (int i = 0; i < academias.size(); i++) {
            if (academias.get(i).id() == academiaAtualizada.id()) {
                academias.set(i, academiaAtualizada);
                break;
            }
        }
        registrarNoArquivo(academias);
    }

    public void removerPorId(int id) {
        List<Academia> academias = buscarAcademias();
        boolean encontrou = false;

        for (int i = 0; i < academias.size(); i++) {
            if (academias.get(i).id() == id) {
                academias.remove(i);
                encontrou = true;
                break;
            }
        }

        if (encontrou) {
            for (int i = 0; i < academias.size(); i++) {
                Academia antiga = academias.get(i);
                academias.set(i, new Academia(
                    i + 1,
                    antiga.nome(),
                    antiga.telefone(),
                    antiga.sedePrincipal(),
                    antiga.quantidadeDeFiliais(),
                    antiga.planoMensal()
                ));
            }
            registrarNoArquivo(academias);
            logger.info("Academia removida com sucesso e IDs reorganizados.");
        } else {
            logger.warning("Academia com ID " + id + " não encontrada.");
        }
    }

    private void registrarNoArquivo(List<Academia> academias) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ACADEMIAS))) {
            for (Academia academia : academias) {
                writer.write(academia.id() + "," + academia.nome() + "," + academia.telefone() + "," + academia.sedePrincipal() + "," + academia.quantidadeDeFiliais() + "," + academia.planoMensal());
                writer.newLine();
            }
        } catch (IOException e) {
            logger.severe("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
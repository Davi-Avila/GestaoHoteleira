package core.service;

import base.enumeration.Funcionalidade;
import base.exception.PessoaException;
import base.util.Utilidades;
import core.dao.PacoteDAO;
import core.dao.PessoaDAO;
import core.model.Acomodacao;
import core.model.Pacote;
import core.model.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacoteService {
    private PacoteDAO pacoteDAO;

    // Construtor
    public PacoteService(PacoteDAO pacoteDAO) {
        this.pacoteDAO = pacoteDAO;
    }

    // Métodos públicos

    public String listar() throws PacoteException {
        ArrayList<Pessoa> pessoas =  pacoteDAO.selecionar();
        String lista = "";
        if(pessoas.size() > 0) {
            for (Pessoa pessoa : pessoas) {
                lista += pessoa + "\n";
            }
        } else {
            lista = "Nenhuma pessoa encontrada.";
        }
        return lista;
    }

    public String cadastrar(
            Long id,
            Acomodacao Acomodacao,
            String nome,
            int qtdDiarias,
            int valorTotal
    ) throws PessoaException {
        String mensagemErro =
                (Funcionalidade.CADASTRAR, null, nomeCompleto, dataNascimentoFormatoBR, documento);
        if(!mensagemErro.isEmpty()) throw new PessoaException(mensagemErro);
        Pacote pacote = new Pacote(
                Long id,
                Acomodacao Acomodacao,
                String nome,
                int qtdDiarias,
                int valorTotal
        );

        if(pacoteDAO.inserir(pacote)) {
            return "Pessoa cadastrada com sucesso!";
        } else {
            throw new PessoaException("Não foi possível cadastrar a pessoa! Por favor, tente novamente.");
        }
    }
}

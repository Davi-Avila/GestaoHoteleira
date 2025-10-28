package core.test;

import base.enumeration.Funcionalidade;
import base.exception.AcomodacaoException;
import base.exception.PacoteException;
import base.exception.PessoaException;
import core.model.Acomodacao;
import core.service.PacoteService;
import core.service.PessoaService;

public class PacoteTest {
    private PacoteService pacoteService;

    // Construtor
    public PacoteTest(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }
    // Métodos de testes

    public String testar(Funcionalidade funcionalidade) throws PacoteException, AcomodacaoException {
        switch (funcionalidade) {
            case LISTAR:
            case CADASTRAR:
                return this.cadastrar();
            case EXCLUIR:
                return this.excluir();
            default:
                return null;
        }
    }


    public String cadastrar() throws PacoteException, AcomodacaoException {
        // Dados para cadastro
        String nome = "Vitor";
        String acomodacao = "2";
        String qtdDiarias = "3";
        String valorTotal = "5.0";

        return pacoteService.cadastrar(nome, acomodacao, qtdDiarias, valorTotal);
    }

    public String excluir() throws PacoteException {
        // Dados para exclusão
        String id = "11";
        return pacoteService.excluir(id);
    }
}

package core.test;

import base.enumeration.Funcionalidade;
import base.exception.PessoaException;
import core.service.PacoteService;
import core.service.PessoaService;

public class PacoteTest {
    private PacoteService pacoteService;

    // Construtor
    public PacoteTest(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    // Métodos de testes

    public String testar(Funcionalidade funcionalidade) throws PessoaException {
        switch (funcionalidade) {
            case LISTAR:
                return this.listar();
            case CADASTRAR:
                return this.cadastrar();
            default:
                return null;
        }
    }

    public String listar() throws PessoaException {
        return pacoteService.listar();
    }

    public String cadastrar() throws PessoaException {
        // Dados para cadastro

        return pacoteService.cadastrar();
    }

}

import base.exception.PessoaException;
import core.controller.PacoteController;
import core.controller.PessoaController;
import core.dao.PacoteDAO;
import core.dao.PessoaDAO;
import core.model.Pacote;
import core.service.PacoteService;
import core.service.PessoaService;
import core.test.PacoteTest;
import core.test.PessoaTest;

public class PrincipalPacote {
    public static void main(String[] args) throws PessoaException {
        PacoteDAO pacoteDAO = new PacoteDAO();
        PacoteService pacoteService = new PacoteService(pacoteDAO);
        PacoteTest pacoteTest = new PacoteTest(pacoteService);
        PacoteController pacoteController = new PacoteController(pacoteTest);
        pacoteController.iniciar();
    }
}

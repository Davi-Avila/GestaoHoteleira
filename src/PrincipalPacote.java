import base.exception.AcomodacaoException;
import base.exception.PacoteException;
import base.exception.PessoaException;
import core.controller.PacoteController;
import core.dao.PacoteDAO;
import core.service.PacoteService;
import core.test.PacoteTest;

public class PrincipalPacote {
    public static void main(String[] args) throws AcomodacaoException, PacoteException {
        PacoteDAO pacoteDAO = new PacoteDAO();
        PacoteService pacoteService = new PacoteService(pacoteDAO);
        PacoteTest pacoteTest = new PacoteTest(pacoteService);
        PacoteController pacoteController = new PacoteController(pacoteTest);
        pacoteController.iniciar();
    }
}

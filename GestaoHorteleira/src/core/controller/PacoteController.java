package core.controller;

import base.enumeration.Funcionalidade;
import base.exception.AcomodacaoException;
import base.exception.PacoteException;
import base.exception.PessoaException;
import core.model.Acomodacao;
import core.model.Funcionario;
import core.service.PacoteService;
import core.test.PacoteTest;
import core.test.PessoaTest;

import java.time.LocalDate;
import java.util.Scanner;

public class PacoteController {
    private PacoteTest pacoteTest;

    // Construtor
    public PacoteController(PacoteTest pacoteTest) {
        this.pacoteTest = pacoteTest;
    }

    // Gerenciador de testes
    public void iniciar() throws AcomodacaoException, PacoteException {

        Scanner entrada = new Scanner(System.in);
        String opcao = null;

        System.out.println(
                "=== TESTE MODULO PESSOA ===\n"
                        + "1 - Listar\n"
                        + "2 - Cadastrar\n"
                        + "3 - Deletar\n"
                        + "4 - Alterar"
        );

        do {
            System.out.println("\nEscolha a funcionalidade:");
            opcao = entrada.nextLine();


            Funcionalidade funcionalidade = null;
            switch (opcao) {
                case "2":
                    funcionalidade = Funcionalidade.CADASTRAR;
                    break;
                case "3":
                    funcionalidade = funcionalidade.EXCLUIR;
                    break;
                case "4":
                    funcionalidade = funcionalidade.ALTERAR;
                    break;

            }

            if(funcionalidade != null) {
                try {
                    System.out.println("Funcionalidade: " + funcionalidade);
                    System.out.println(pacoteTest.testar(funcionalidade));
                } catch(PacoteException excecao) {
                    System.err.println(excecao.getMessage());
                }
            }

        }while (!opcao.isEmpty());
    }


}

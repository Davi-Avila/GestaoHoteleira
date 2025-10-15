package core.controller;

import base.enumeration.Funcionalidade;
import base.exception.PessoaException;
import core.test.PacoteTest;
import core.test.PessoaTest;

import java.util.Scanner;

public class PacoteController {
    private PacoteTest pacoteTest;

    // Construtor
    public PacoteController(PacoteTest pacoteTest) {
        this.pacoteTest = pacoteTest;
    }

    // Gerenciador de testes
    public void iniciar() throws PessoaException {
        Scanner entrada = new Scanner(System.in);
        String opcao = null;

        System.out.println(
                "=== TESTE MODULO PESSOA ===\n"
                        + "1 - Listar\n"
                        + "2 - Cadastrar\n"
        );

        do {
            System.out.println("\nEscolha a funcionalidade:");
            opcao = entrada.nextLine();

            Funcionalidade funcionalidade = null;
            switch (opcao) {
                case "1":
                    funcionalidade = Funcionalidade.LISTAR;
                    break;
                case "2":
                    funcionalidade = Funcionalidade.CADASTRAR;
                    break;

            }
            if (funcionalidade != null) {
                try {
                    System.out.println("Funcionalidade: " + funcionalidade);
                    System.out.println(pacoteTest.testar(funcionalidade));
                } catch (PessoaException excecao) {
                    System.err.println(excecao.getMessage());
                }
            }
        }while (!opcao.isEmpty());
    }
}

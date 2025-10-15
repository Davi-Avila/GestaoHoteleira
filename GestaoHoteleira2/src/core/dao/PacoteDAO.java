package core.dao;

import base.connection.ConexaoMySQL;
import base.exception.PessoaException;
import core.model.Acomodacao;
import core.model.Pacote;
import core.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;

public class PacoteDAO {
    // Métodos de interação com banco de dados


    public Boolean inserir(Pacote pacote) throws PessoaException {
        try {
            String sql = "INSERT INTO pacote (id_acomodacao, nome, qtd_diarias, valor_total) VALUES (?, ?, ?, ?) ";

            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, pacote.getAcomodacao().getId());
            preparacao.setString(2, pacote.getNome());
            preparacao.setInt(3, pacote.getQtdDiarias());
            preparacao.setDouble(4, pacote.getValorTotal());

            return preparacao.executeUpdate() > 0;

        } catch (Exception e) {
            throw new PessoaException("Erro desconhecido! Por favor, tente novamente mais tarde.");
        }
    }

}

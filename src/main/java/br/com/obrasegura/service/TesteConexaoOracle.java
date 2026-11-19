
package br.com.obrasegura.service;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexaoOracle {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" TESTE DE CONEXAO - OBRASSEGURA");
        System.out.println("================================");

        try (Connection conexao = ConexaoOracle.conectar()) {

            System.out.println("Conexão realizada com sucesso!");
            System.out.println("Banco de dados: "
                    + conexao.getMetaData().getDatabaseProductName());
            System.out.println("Versão: "
                    + conexao.getMetaData().getDatabaseProductVersion());

        } catch (SQLException e) {

            System.out.println("Erro ao conectar com o Oracle:");
            System.out.println(e.getMessage());

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("================================");
    }
}


package br.com.obrasegura.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {

    private static final String URL =
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    public static Connection conectar() throws SQLException {

        String usuario = System.getenv("ORACLE_USER");
        String senha = System.getenv("ORACLE_PASSWORD");

        if (usuario == null || senha == null) {
            throw new IllegalStateException(
                    "Configure ORACLE_USER e ORACLE_PASSWORD."
            );
        }

        return DriverManager.getConnection(URL, usuario, senha);
    }
}

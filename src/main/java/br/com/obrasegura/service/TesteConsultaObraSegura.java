package br.com.obrasegura.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteConsultaObraSegura {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("MONITORAMENTO OBRASEGURA");
        System.out.println("========================================");

        String sql = """
                SELECT
                    O.NOME AS OBRA,
                    O.CIDADE,
                    O.ESTADO,
                    A.DESCRICAO AS ATIVIDADE,
                    S.IDENTIFICACAO AS SENSOR,
                    S.TIPO_SENSOR,
                    S.LOCALIZACAO AS LOCAL_SENSOR,
                    L.VALOR AS VALOR_LEITURA,
                    L.UNIDADE,
                    L.OBSERVACAO AS LEITURA,
                    AL.TITULO AS TITULO_ALERTA,
                    AL.DESCRICAO AS DESCRICAO_ALERTA,
                    AL.NIVEL,
                    AL.STATUS AS STATUS_ALERTA,
                    AL.DATA_HORA
                FROM OBRA O
                INNER JOIN ATIVIDADE A
                    ON A.OBRA_ID_OBRA = O.ID_OBRA
                INNER JOIN SENSOR S
                    ON S.OBRA_ID_OBRA = O.ID_OBRA
                INNER JOIN LEITURA_SENSOR L
                    ON L.SENSOR_ID_SENSOR = S.ID_SENSOR
                INNER JOIN ALERTA AL
                    ON AL.ID_SENSOR = S.ID_SENSOR
                   AND AL.ID_OBRA = O.ID_OBRA
                """;

        try (Connection conexao = ConexaoOracle.conectar()) {

            System.out.println("\nConexao com Oracle estabelecida!");

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                boolean encontrou = false;

                while (rs.next()) {

                    encontrou = true;

                    System.out.println("\n========================================");
                    System.out.println("DADOS DA OBRA");
                    System.out.println("========================================");

                    System.out.println("Obra: " + rs.getString("OBRA"));
                    System.out.println("Cidade: " + rs.getString("CIDADE"));
                    System.out.println("Estado: " + rs.getString("ESTADO"));

                    System.out.println("\n========================================");
                    System.out.println("ATIVIDADE");
                    System.out.println("========================================");

                    System.out.println("Atividade: " + rs.getString("ATIVIDADE"));

                    System.out.println("\n========================================");
                    System.out.println("SENSOR");
                    System.out.println("========================================");

                    System.out.println("Identificacao: " + rs.getString("SENSOR"));
                    System.out.println("Tipo: " + rs.getString("TIPO_SENSOR"));
                    System.out.println("Local: " + rs.getString("LOCAL_SENSOR"));

                    System.out.println("\n========================================");
                    System.out.println("LEITURA DO SENSOR");
                    System.out.println("========================================");

                    System.out.println("Valor: " + rs.getString("VALOR_LEITURA"));
                    System.out.println("Unidade: " + rs.getString("UNIDADE"));
                    System.out.println("Descricao: " + rs.getString("LEITURA"));

                    System.out.println("\n========================================");
                    System.out.println("ALERTA DE SEGURANCA");
                    System.out.println("========================================");

                    System.out.println("Titulo: " + rs.getString("TITULO_ALERTA"));
                    System.out.println("Descricao: " + rs.getString("DESCRICAO_ALERTA"));
                    System.out.println("Nivel: " + rs.getString("NIVEL"));
                    System.out.println("Status: " + rs.getString("STATUS_ALERTA"));
                    System.out.println("Data: " + rs.getString("DATA_HORA"));

                    System.out.println("\n========================================");
                }

                if (!encontrou) {
                    System.out.println("Nenhum monitoramento encontrado.");
                }

            }

        } catch (SQLException e) {

            System.out.println("\nErro ao consultar o banco de dados:");
            e.printStackTrace();

        } catch (IllegalStateException e) {

            System.out.println("\nErro de configuracao:");
            System.out.println(e.getMessage());

        }

        System.out.println("\n========================================");
        System.out.println("CONSULTA FINALIZADA");
        System.out.println("========================================");
    }
}
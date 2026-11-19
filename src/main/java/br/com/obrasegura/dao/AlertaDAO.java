
package br.com.obrasegura.dao;

import br.com.obrasegura.model.Alerta;
import br.com.obrasegura.service.ConexaoOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

public class AlertaDAO {

    // SALVAR ALERTA
    public void salvar(Alerta alerta) throws SQLException {

        String sql = """
                INSERT INTO ALERTA (
                    ID_OBRA,
                    ID_SENSOR,
                    TITULO,
                    DESCRICAO,
                    NIVEL,
                    STATUS,
                    DATA_HORA
                ) VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conexao = ConexaoOracle.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setLong(1, alerta.getIdObra());

            if (alerta.getIdSensor() == null) {
                statement.setNull(2, Types.NUMERIC);
            } else {
                statement.setLong(2, alerta.getIdSensor());
            }

            statement.setString(3, alerta.getTitulo());
            statement.setString(4, alerta.getDescricao());
            statement.setString(5, alerta.getNivel());
            statement.setString(6, alerta.getStatus());

            statement.setTimestamp(
                    7,
                    Timestamp.valueOf(alerta.getDataHora())
            );

            statement.executeUpdate();
        }
    }

    // ATUALIZAR STATUS DO ALERTA
    public boolean atualizarStatus(Long idAlerta, String novoStatus)
            throws SQLException {

        String sql = """
                UPDATE ALERTA
                SET STATUS = ?
                WHERE ID_ALERTA = ?
                """;

        try (Connection conexao = ConexaoOracle.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, novoStatus);
            statement.setLong(2, idAlerta);

            int linhasAlteradas = statement.executeUpdate();

            return linhasAlteradas > 0;
        }
    }
}

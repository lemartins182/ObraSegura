
package br.com.obrasegura.dao;

import br.com.obrasegura.dto.MonitoramentoDTO;
import br.com.obrasegura.service.ConexaoOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonitoramentoDAO {

    public List<MonitoramentoDTO> consultarMonitoramento() throws SQLException {

        List<MonitoramentoDTO> monitoramentos = new ArrayList<>();

        String sql = """
                SELECT
                    AL.ID_ALERTA,
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
                ORDER BY AL.DATA_HORA DESC
                """;

        try (Connection conexao = ConexaoOracle.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                MonitoramentoDTO dto = new MonitoramentoDTO(
                        rs.getLong("ID_ALERTA"),
                        rs.getString("OBRA"),
                        rs.getString("CIDADE"),
                        rs.getString("ESTADO"),
                        rs.getString("ATIVIDADE"),
                        rs.getString("SENSOR"),
                        rs.getString("TIPO_SENSOR"),
                        rs.getString("LOCAL_SENSOR"),
                        rs.getString("VALOR_LEITURA"),
                        rs.getString("UNIDADE"),
                        rs.getString("LEITURA"),
                        rs.getString("TITULO_ALERTA"),
                        rs.getString("DESCRICAO_ALERTA"),
                        rs.getString("NIVEL"),
                        rs.getString("STATUS_ALERTA"),
                        rs.getTimestamp("DATA_HORA").toLocalDateTime()
                );

                monitoramentos.add(dto);
            }
        }

        return monitoramentos;
    }
}

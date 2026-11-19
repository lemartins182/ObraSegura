package br.com.obrasegura.controller;

import br.com.obrasegura.dao.AlertaDAO;
import br.com.obrasegura.model.Alerta;
import br.com.obrasegura.model.SensorMovimento;
import br.com.obrasegura.service.MonitoramentoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDateTime;

@RestController
public class SimulacaoController {

    private final MonitoramentoService monitoramentoService =
            new MonitoramentoService();

    private final AlertaDAO alertaDAO = new AlertaDAO();

    @PostMapping("/api/simulacao/movimento")
    public String simularMovimentoAnormal() {

        // 1. Simulando o sensor
        SensorMovimento sensor = new SensorMovimento(
                2L,
                1L,
                "SENSOR-MOV-002",
                "Andaime - Setor A",
                "ATIVO",
                LocalDateTime.now(),
                1.8,
                0.7,
                2.4,
                true
        );

        // 2. Analisando o movimento
        Alerta alerta = monitoramentoService.analisarMovimento(sensor);

        // 3. Verificando se foi gerado alerta
        if (alerta == null) {
            return "Nenhum alerta gerado. Movimento dentro dos parâmetros normais.";
        }

        // 4. Salvando no Oracle
        try {

            alertaDAO.salvar(alerta);

            return "Alerta gerado e salvo com sucesso!";

        } catch (SQLException e) {

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao salvar o alerta no banco Oracle.",
                    e
            );
        }
    }
}
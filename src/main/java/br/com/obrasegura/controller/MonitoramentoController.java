package br.com.obrasegura.controller;

import br.com.obrasegura.dao.MonitoramentoDAO;
import br.com.obrasegura.dto.MonitoramentoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MonitoramentoController {

    private final MonitoramentoDAO monitoramentoDAO = new MonitoramentoDAO();

    @GetMapping("/api/monitoramento")
    public List<MonitoramentoDTO> consultarMonitoramento() {

        try {
            return monitoramentoDAO.consultarMonitoramento();

        } catch (SQLException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao consultar o monitoramento no banco Oracle.",
                    e
            );
        }
    }
}
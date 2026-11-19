
package br.com.obrasegura.controller;

import br.com.obrasegura.dao.AlertaDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@RestController
public class AlertaController {

    private final AlertaDAO alertaDAO = new AlertaDAO();

    @PutMapping("/api/alertas/{id}/verificar")
    public String verificarAlerta(@PathVariable Long id) {

        try {

            boolean atualizado = alertaDAO.atualizarStatus(
                    id,
                    "VERIFICADO"
            );

            if (!atualizado) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Alerta não encontrado."
                );
            }

            return "Alerta " + id + " verificado com sucesso!";

        } catch (SQLException e) {

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao atualizar o alerta no banco Oracle.",
                    e
            );
        }
    }
}

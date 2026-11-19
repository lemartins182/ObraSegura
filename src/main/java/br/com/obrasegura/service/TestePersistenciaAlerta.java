
package br.com.obrasegura.service;

import br.com.obrasegura.dao.AlertaDAO;
import br.com.obrasegura.model.Alerta;
import br.com.obrasegura.model.SensorMovimento;

import java.time.LocalDateTime;

public class TestePersistenciaAlerta {

    public static void main(String[] args) {

        // Simulando um sensor de movimento
        SensorMovimento sensor = new SensorMovimento(
                2L,
                1L,
                "SEN-MOV-001",
                "Andaime - Setor A",
                "ATIVO",
                LocalDateTime.now(),
                2.5,
                1.8,
                9.8,
                true
        );

        // Analisando a leitura do sensor
        MonitoramentoService monitoramento = new MonitoramentoService();
        Alerta alerta = monitoramento.analisarMovimento(sensor);

        if (alerta != null) {

            try {
                // Salvando o alerta no Oracle
                AlertaDAO dao = new AlertaDAO();
                dao.salvar(alerta);

                System.out.println("================================");
                System.out.println("ALERTA SALVO COM SUCESSO!");
                System.out.println("Título: " + alerta.getTitulo());
                System.out.println("Status: " + alerta.getStatus());
                System.out.println("================================");

            } catch (Exception e) {
                System.out.println("Erro ao salvar alerta:");
                e.printStackTrace();
            }

        } else {
            System.out.println("Nenhum alerta foi gerado.");
        }
    }
}

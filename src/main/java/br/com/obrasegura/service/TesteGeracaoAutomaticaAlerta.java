package br.com.obrasegura.service;

import br.com.obrasegura.model.Alerta;
import br.com.obrasegura.model.SensorMovimento;
import br.com.obrasegura.dao.AlertaDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TesteGeracaoAutomaticaAlerta {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" TESTE DE GERACAO AUTOMATICA DE ALERTA");
        System.out.println("======================================");

        // 1. Simulando um sensor de movimento
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

        System.out.println("\nSENSOR:");
        System.out.println("Identificacao: " + sensor.getIdentificacao());
        System.out.println("Localizacao: " + sensor.getLocalizacao());
        System.out.println("Status: " + sensor.getStatus());

        // 2. Executando a analise do sensor
        MonitoramentoService monitoramento = new MonitoramentoService();

        Alerta alerta = monitoramento.analisarMovimento(sensor);

        // 3. Verificando se houve alerta
        if (alerta != null) {

            System.out.println("\nALERTA GERADO AUTOMATICAMENTE!");
            System.out.println("--------------------------------------");
            System.out.println("Titulo: " + alerta.getTitulo());
            System.out.println("Descricao: " + alerta.getDescricao());
            System.out.println("Nivel: " + alerta.getNivel());
            System.out.println("Status: " + alerta.getStatus());
            System.out.println("Data/Hora: " + alerta.getDataHora());

            // 4. Salvando o alerta no Oracle
            AlertaDAO alertaDAO = new AlertaDAO();

            try {
                alertaDAO.salvar(alerta);

                System.out.println("\nALERTA SALVO NO BANCO ORACLE!");
            } catch (SQLException e) {
                System.out.println("\nERRO AO SALVAR ALERTA:");
                e.printStackTrace();
            }

        } else {

            System.out.println("\nNenhum alerta foi gerado.");
            System.out.println("Movimento dentro dos parametros normais.");
        }

        System.out.println("\n======================================");
        System.out.println(" TESTE FINALIZADO");
        System.out.println("======================================");
    }
}
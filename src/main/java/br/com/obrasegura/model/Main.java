
package br.com.obrasegura.model;

import br.com.obrasegura.service.MonitoramentoService;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // Criando o sensor ambiental
        Sensor sensorAmbiental = new SensorAmbiental(
                1L,
                1L,
                "SEN-AMB-001",
                "Área de trabalho em altura",
                "ATIVO",
                LocalDateTime.now(),
                32.5,
                70.0,
                1013.0
        );

        // Criando o sensor de movimento
        SensorMovimento sensorMovimento = new SensorMovimento(
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

        // Criando o serviço de monitoramento
        MonitoramentoService monitoramento = new MonitoramentoService();

        System.out.println("================================");
        System.out.println("       OBRASSEGURA - IOT");
        System.out.println("================================");

        // Exibindo leitura ambiental
        System.out.println("\nLEITURA DO SENSOR AMBIENTAL:");
        System.out.println(sensorAmbiental.capturarLeitura());

        // Exibindo leitura de movimento
        System.out.println("\nLEITURA DO SENSOR DE MOVIMENTO:");
        System.out.println(sensorMovimento.capturarLeitura());

        // Analisando o sensor e verificando a necessidade de alerta
        Alerta alerta = monitoramento.analisarMovimento(sensorMovimento);

        if (alerta != null) {

            System.out.println("\n================================");
            System.out.println("          ALERTA GERADO");
            System.out.println("================================");

            System.out.println("Título: " + alerta.getTitulo());
            System.out.println("Descrição: " + alerta.getDescricao());
            System.out.println("Nível: " + alerta.getNivel());
            System.out.println("Status: " + alerta.getStatus());

        } else {

            System.out.println("\nNenhuma movimentação anormal identificada.");
        }

        System.out.println("\n================================");
        System.out.println("Monitoramento finalizado.");
    }
}

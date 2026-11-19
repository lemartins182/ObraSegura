
package br.com.obrasegura.model;

import java.time.LocalDateTime;

public class SensorAmbiental extends Sensor {

    private double temperatura;
    private double umidade;
    private double pressao;

    public SensorAmbiental() {
    }

    public SensorAmbiental(Long idSensor, Long idObra,
                           String identificacao, String localizacao,
                           String status, LocalDateTime dataInstalacao,
                           double temperatura, double umidade,
                           double pressao) {

        super(idSensor, idObra, identificacao, "AMBIENTAL",
                localizacao, status, dataInstalacao);

        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
    }

    @Override
    public String capturarLeitura() {
        return "Temperatura: " + temperatura + " °C"
                + " | Umidade: " + umidade + "%"
                + " | Pressão: " + pressao + " hPa";
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
}

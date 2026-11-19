
package br.com.obrasegura.model;

import java.time.LocalDateTime;

public abstract class Sensor {

    private Long idSensor;
    private Long idObra;
    private String identificacao;
    private String tipo;
    private String localizacao;
    private String status;
    private LocalDateTime dataInstalacao;

    public Sensor() {
    }

    public Sensor(Long idSensor, Long idObra,
                  String identificacao, String tipo,
                  String localizacao, String status,
                  LocalDateTime dataInstalacao) {

        this.idSensor = idSensor;
        this.idObra = idObra;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.status = status;
        this.dataInstalacao = dataInstalacao;
    }

    public abstract String capturarLeitura();

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDateTime dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }
}

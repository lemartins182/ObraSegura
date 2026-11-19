
package br.com.obrasegura.model;

import java.time.LocalDateTime;

public class LeituraSensor {

    private Long idLeitura;
    private Long idSensor;
    private LocalDateTime dataHora;
    private String valor;
    private String unidadeMedida;
    private String observacao;

    public LeituraSensor() {
    }

    public LeituraSensor(Long idLeitura, Long idSensor,
                         LocalDateTime dataHora, String valor,
                         String unidadeMedida, String observacao) {

        this.idLeitura = idLeitura;
        this.idSensor = idSensor;
        this.dataHora = dataHora;
        this.valor = valor;
        this.unidadeMedida = unidadeMedida;
        this.observacao = observacao;
    }

    public Long getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Long idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

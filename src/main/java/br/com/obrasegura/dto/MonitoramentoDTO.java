
package br.com.obrasegura.dto;

import java.time.LocalDateTime;

public class MonitoramentoDTO {

    private Long idAlerta;
    private String obra;
    private String cidade;
    private String estado;
    private String atividade;
    private String sensor;
    private String tipoSensor;
    private String localSensor;
    private String valorLeitura;
    private String unidade;
    private String leitura;
    private String tituloAlerta;
    private String descricaoAlerta;
    private String nivel;
    private String statusAlerta;
    private LocalDateTime dataHora;

    public MonitoramentoDTO() {
    }

    public MonitoramentoDTO(
            Long idAlerta,
            String obra,
            String cidade,
            String estado,
            String atividade,
            String sensor,
            String tipoSensor,
            String localSensor,
            String valorLeitura,
            String unidade,
            String leitura,
            String tituloAlerta,
            String descricaoAlerta,
            String nivel,
            String statusAlerta,
            LocalDateTime dataHora) {

        this.idAlerta = idAlerta;
        this.obra = obra;
        this.cidade = cidade;
        this.estado = estado;
        this.atividade = atividade;
        this.sensor = sensor;
        this.tipoSensor = tipoSensor;
        this.localSensor = localSensor;
        this.valorLeitura = valorLeitura;
        this.unidade = unidade;
        this.leitura = leitura;
        this.tituloAlerta = tituloAlerta;
        this.descricaoAlerta = descricaoAlerta;
        this.nivel = nivel;
        this.statusAlerta = statusAlerta;
        this.dataHora = dataHora;
    }

    public Long getIdAlerta() {
        return idAlerta;
    }

    public String getObra() {
        return obra;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getAtividade() {
        return atividade;
    }

    public String getSensor() {
        return sensor;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public String getLocalSensor() {
        return localSensor;
    }

    public String getValorLeitura() {
        return valorLeitura;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getLeitura() {
        return leitura;
    }

    public String getTituloAlerta() {
        return tituloAlerta;
    }

    public String getDescricaoAlerta() {
        return descricaoAlerta;
    }

    public String getNivel() {
        return nivel;
    }

    public String getStatusAlerta() {
        return statusAlerta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}

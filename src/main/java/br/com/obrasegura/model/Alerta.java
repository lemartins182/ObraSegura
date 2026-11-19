
package br.com.obrasegura.model;

import java.time.LocalDateTime;

public class Alerta {

    private Long idAlerta;
    private Long idObra;
    private Long idSensor;
    private String titulo;
    private String descricao;
    private String nivel;
    private String status;
    private LocalDateTime dataHora;

    public Alerta() {
    }

    public Alerta(Long idAlerta, Long idObra, Long idSensor,
                  String titulo, String descricao, String nivel,
                  String status, LocalDateTime dataHora) {

        this.idAlerta = idAlerta;
        this.idObra = idObra;
        this.idSensor = idSensor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.status = status;
        this.dataHora = dataHora;
    }

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}


package br.com.obrasegura.model;

import java.time.LocalDate;

public class Inspecao {

    private Long idInspecao;
    private Long idAtividade;
    private Long idUsuario;
    private LocalDate dataInspecao;
    private String tipoInspecao;
    private String resultado;
    private String observacoes;
    private String status;

    public Inspecao() {
    }

    public Inspecao(Long idInspecao, Long idAtividade,
                    Long idUsuario, LocalDate dataInspecao,
                    String tipoInspecao, String resultado,
                    String observacoes, String status) {

        this.idInspecao = idInspecao;
        this.idAtividade = idAtividade;
        this.idUsuario = idUsuario;
        this.dataInspecao = dataInspecao;
        this.tipoInspecao = tipoInspecao;
        this.resultado = resultado;
        this.observacoes = observacoes;
        this.status = status;
    }

    public Long getIdInspecao() {
        return idInspecao;
    }

    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(LocalDate dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public String getTipoInspecao() {
        return tipoInspecao;
    }

    public void setTipoInspecao(String tipoInspecao) {
        this.tipoInspecao = tipoInspecao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

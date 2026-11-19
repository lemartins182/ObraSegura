
package br.com.obrasegura.model;

import java.time.LocalDate;

public class Atividade {

    private Long idAtividade;
    private String descricao;
    private String tipoAtividade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;

    public Atividade() {
    }

    public Atividade(Long idAtividade, String descricao,
                     String tipoAtividade, LocalDate dataInicio,
                     LocalDate dataFim, String status) {

        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.tipoAtividade = tipoAtividade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

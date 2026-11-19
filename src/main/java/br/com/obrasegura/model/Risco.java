
package br.com.obrasegura.model;

import java.time.LocalDate;

public class Risco {

    private Long idRisco;
    private Long idAtividade;
    private String titulo;
    private String descricao;
    private String categoria;
    private String probabilidade;
    private String severidade;
    private String nivelRisco;
    private String medidaPreventiva;
    private String status;
    private LocalDate dataIdentificacao;

    public Risco() {
    }

    public Risco(Long idRisco, Long idAtividade, String titulo,
                 String descricao, String categoria,
                 String probabilidade, String severidade,
                 String nivelRisco, String medidaPreventiva,
                 String status, LocalDate dataIdentificacao) {

        this.idRisco = idRisco;
        this.idAtividade = idAtividade;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.probabilidade = probabilidade;
        this.severidade = severidade;
        this.nivelRisco = nivelRisco;
        this.medidaPreventiva = medidaPreventiva;
        this.status = status;
        this.dataIdentificacao = dataIdentificacao;
    }

    public Long getIdRisco() {
        return idRisco;
    }

    public void setIdRisco(Long idRisco) {
        this.idRisco = idRisco;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(String probabilidade) {
        this.probabilidade = probabilidade;
    }

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public String getMedidaPreventiva() {
        return medidaPreventiva;
    }

    public void setMedidaPreventiva(String medidaPreventiva) {
        this.medidaPreventiva = medidaPreventiva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataIdentificacao() {
        return dataIdentificacao;
    }

    public void setDataIdentificacao(LocalDate dataIdentificacao) {
        this.dataIdentificacao = dataIdentificacao;
    }
}

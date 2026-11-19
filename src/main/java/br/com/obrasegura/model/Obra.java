
package br.com.obrasegura.model;

import java.time.LocalDate;

public class Obra {

    private Long idObra;
    private String nome;
    private String descricao;
    private String endereco;
    private String cidade;
    private String estado;
    private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;
    private String status;

    public Obra() {
    }

    public Obra(Long idObra, String nome, String descricao,
                String endereco, String cidade, String estado,
                LocalDate dataInicio, LocalDate dataPrevisaoFim,
                String status) {

        this.idObra = idObra;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.dataInicio = dataInicio;
        this.dataPrevisaoFim = dataPrevisaoFim;
        this.status = status;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

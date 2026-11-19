
package br.com.obrasegura.model;

import java.time.LocalDate;

public class ParticipacaoAtividade {

    private Long idParticipacao;
    private Long idUsuario;
    private Long idAtividade;
    private String funcaoAtividade;
    private LocalDate dataAlocacao;
    private String status;

    public ParticipacaoAtividade() {
    }

    public ParticipacaoAtividade(Long idParticipacao, Long idUsuario,
                                 Long idAtividade, String funcaoAtividade,
                                 LocalDate dataAlocacao, String status) {

        this.idParticipacao = idParticipacao;
        this.idUsuario = idUsuario;
        this.idAtividade = idAtividade;
        this.funcaoAtividade = funcaoAtividade;
        this.dataAlocacao = dataAlocacao;
        this.status = status;
    }

    public Long getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(Long idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getFuncaoAtividade() {
        return funcaoAtividade;
    }

    public void setFuncaoAtividade(String funcaoAtividade) {
        this.funcaoAtividade = funcaoAtividade;
    }

    public LocalDate getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(LocalDate dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

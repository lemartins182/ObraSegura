
package br.com.obrasegura.model;

import java.time.LocalDate;

public class TecnicoSeguranca extends Usuario {

    private String registroProfissional;
    private String formacao;

    public TecnicoSeguranca() {
        super();
    }

    public TecnicoSeguranca(Long idUsuario, String nome, String email,
                            String senhaHash, String tipoUsuario,
                            LocalDate dataCadastro, boolean ativo,
                            String registroProfissional, String formacao) {

        super(idUsuario, nome, email, senhaHash,
                tipoUsuario, dataCadastro, ativo);

        this.registroProfissional = registroProfissional;
        this.formacao = formacao;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}

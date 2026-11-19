
package br.com.obrasegura.model;

import java.time.LocalDate;

public class Engenheiro extends Usuario {

    private String crea;
    private String especialidade;

    public Engenheiro() {
        super();
    }

    public Engenheiro(Long idUsuario, String nome, String email,
                      String senhaHash, String tipoUsuario,
                      LocalDate dataCadastro, boolean ativo,
                      String crea, String especialidade) {

        super(idUsuario, nome, email, senhaHash,
                tipoUsuario, dataCadastro, ativo);

        this.crea = crea;
        this.especialidade = especialidade;
    }

    public String getCrea() {
        return crea;
    }

    public void setCrea(String crea) {
        this.crea = crea;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

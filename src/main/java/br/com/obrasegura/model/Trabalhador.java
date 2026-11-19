
package br.com.obrasegura.model;

public class Trabalhador extends Usuario {

    private String cpf;
    private String funcao;
    private String telefone;

    public Trabalhador() {
        super();
    }

    public Trabalhador(Long idUsuario, String nome, String email,
                       String senhaHash, String tipoUsuario,
                       java.time.LocalDate dataCadastro, boolean ativo,
                       String cpf, String funcao, String telefone) {

        super(idUsuario, nome, email, senhaHash,
                tipoUsuario, dataCadastro, ativo);

        this.cpf = cpf;
        this.funcao = funcao;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

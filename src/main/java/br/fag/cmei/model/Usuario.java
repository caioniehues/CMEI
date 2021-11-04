package br.fag.cmei.model;

import br.fag.cmei.utils.validador.EmailValido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class Usuario
{
    private long id;

    @NotNull
    @NotEmpty
    private String nome;

    @EmailValido
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String cpf;

    @NotNull
    @NotEmpty
    private String senha;

    private String telefone;

    public Usuario(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }
}

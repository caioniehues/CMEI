package br.fag.cmei.dto;

import br.fag.cmei.utils.validador.CpfValido;
import br.fag.cmei.utils.validador.EmailValido;
import br.fag.cmei.utils.validador.SenhaValida;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SenhaValida
@Getter
@Setter
public class UsuarioDTO {

    @NotEmpty
    @NotNull
    private String nome;

    @EmailValido
    @NotEmpty
    @NotNull
    private String email;

    @CpfValido
    @NotEmpty
    @NotNull
    private String cpf;


    @NotEmpty
    @NotNull
    private String senha;

    @NotEmpty
    @NotNull
    private String confirmaSenha;
}

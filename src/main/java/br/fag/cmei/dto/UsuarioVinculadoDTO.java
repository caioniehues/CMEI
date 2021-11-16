package br.fag.cmei.dto;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.utils.validador.CpfValido;
import br.fag.cmei.utils.validador.EmailValido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioVinculadoDTO {

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


    private UserRoles userRoles;

    @NotEmpty
    @NotEmpty
    private String telefone;


    private String plantao;
}

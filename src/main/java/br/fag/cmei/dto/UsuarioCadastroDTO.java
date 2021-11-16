package br.fag.cmei.dto;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.utils.validador.CpfValido;
import br.fag.cmei.utils.validador.CpfVinculado;
import br.fag.cmei.utils.validador.EmailValido;
import br.fag.cmei.utils.validador.SenhaValida;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SenhaValida
@Getter
@Setter
@NoArgsConstructor
public class UsuarioCadastroDTO {

    @CpfVinculado
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

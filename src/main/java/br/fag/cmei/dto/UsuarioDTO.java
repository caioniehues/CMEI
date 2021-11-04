package br.fag.cmei.dto;

import br.fag.cmei.utils.validador.CpfValido;
import br.fag.cmei.utils.validador.SenhaValida;
import lombok.Data;

@Data
@SenhaValida
@CpfValido
public class UsuarioDTO {

    private String nome;

    private String email;

    private String cpf;

    private String senha;

    private String confirmaSenha;
}

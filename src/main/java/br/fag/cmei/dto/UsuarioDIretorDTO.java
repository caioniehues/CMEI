package br.fag.cmei.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
class UsuarioDIretorDTO
{



    private String nome;

    private String email;

    private String cpf;

    private String senha;

}

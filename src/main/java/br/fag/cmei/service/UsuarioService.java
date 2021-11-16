package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.dto.UsuarioVinculadoDTO;
import br.fag.cmei.entidades.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioService {

    Usuario saveUsuario(UsuarioVinculadoDTO usuarioCadastroDTO) throws Exception;



    Usuario buscaUsuario(String cpg);


}

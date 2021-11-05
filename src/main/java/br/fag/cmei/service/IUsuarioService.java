package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Usuario;

public interface IUsuarioService {
    Usuario cadastrarNovoUsuario(UsuarioDTO usuarioDTO) throws Exception;
}

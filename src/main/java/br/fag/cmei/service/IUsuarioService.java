package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Usuario;
import org.springframework.security.core.userdetails.User;

public interface IUsuarioService {
    Usuario cadastrarNovoUsuario(UsuarioDTO usuarioDTO) throws Exception;

    User buscarPorEmail(UsuarioDTO usuarioDTO) throws Exception;
}

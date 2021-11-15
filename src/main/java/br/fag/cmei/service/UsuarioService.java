package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Cargo;
import br.fag.cmei.entidades.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(UsuarioDTO usuarioDTO) throws Exception;

    Cargo saveCargo(Cargo cargo) throws Exception;

    void addCargoToUsuario(String cof, String nomeCargo);

    Usuario buscaUsuario(String cpg);

    List<Usuario> listarUsuariosPorCargo(Cargo cargo);
}

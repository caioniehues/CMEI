package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Cargo;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario cadastrarNovoUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if(cpfJaCadastrado(usuarioDTO.getCpf())){
            throw new Exception("Usuario já cadastrado!");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getSenha());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setCargoes(List.of(new Cargo("ADMIN")));
        return usuarioRepository.save(usuario);
    }

    @Override
    public User buscarPorEmail(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = usuarioRepository.buscarPorCpf(usuarioDTO.getCpf());
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), null);
    }

    private boolean cpfJaCadastrado(String cpf){
        return usuarioRepository.buscarPorCpf(cpf) != null;
    }
}

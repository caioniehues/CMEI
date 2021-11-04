package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario cadastrarNovoUsuario(UsuarioDTO usuarioDTO) {
//        if(cpfJaCadastrado(usuarioDTO.getCpf())){
//            return;
//        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getSenha());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setCpf(usuarioDTO.getCpf());

        return usuarioRepository.save(usuario);
    }

    private boolean cpfJaCadastrado(String cpf){
        return usuarioRepository.findById(cpf).isPresent();
    }
}

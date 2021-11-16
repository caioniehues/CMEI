package br.fag.cmei.service;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.dto.UsuarioVinculadoDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(UsuarioVinculadoDTO usuarioCadastroDTO) throws Exception {
        log.info("salvando novo usuario no banco {}", usuarioCadastroDTO.getCpf());
        usuarioRepository.save(new Usuario(usuarioCadastroDTO));
        return usuarioRepository.findByCpf(usuarioCadastroDTO.getCpf());
    }

    public Usuario savaUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuarioRepository.findByCpf(usuario.getCpf());
    }

    public List<Usuario> buscarPorCargo(UserRoles userRoles){
        return usuarioRepository.findAllByUserRoles(userRoles);
    }

    @Override
    public Usuario buscaUsuario(String cpf) {
        log.info("buscando o usuario {} no banco", cpf);
        return usuarioRepository.findByCpf(cpf);
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null){
            log.error("usuario não encontrado");
            throw new UsernameNotFoundException("usuario não encontrado");
        }
        Collection<SimpleGrantedAuthority> autoridades = new ArrayList<>();
        autoridades.add(new SimpleGrantedAuthority(usuario.getUserRoles().name()));
        return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha(), autoridades);
    }
}

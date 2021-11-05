package br.fag.cmei.service;

import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.model.Autoridade;
import br.fag.cmei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.buscarPorCpf(cpf);

        if(usuario == null){
            throw new UsernameNotFoundException("No user found with username: " + cpf);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new Autoridade());

        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(), usuario.getSenha().toLowerCase(), true, true,
                true, true, list);


    }
}

package br.fag.cmei.service;

import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Optional<Usuario> user = usuarioRepository.findById(cpf);

        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("No user found with username: " + cpf);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                user.get().getEmail(), user.get().getSenha().toLowerCase(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));

        return null;
    }
}

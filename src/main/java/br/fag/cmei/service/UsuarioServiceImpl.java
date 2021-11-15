package br.fag.cmei.service;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Cargo;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.repository.CargoRepository;
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


    private final CargoRepository cargoRepository;


    @Override
    public Usuario saveUsuario(UsuarioDTO usuarioDTO) throws Exception {
        log.info("salvando novo usuario no banco {}", usuarioDTO.getCpf());
        usuarioRepository.save(new Usuario(usuarioDTO));
        return usuarioRepository.findByCpf(usuarioDTO.getCpf());
    }

    @Override
    public Cargo saveCargo(Cargo cargo) throws Exception {
        log.info("salvando novo cargo no banco {}", cargo.getNome());
        return cargoRepository.save(cargo);
    }

    @Override
    public void addCargoToUsuario(String cpf, String nomeCargo) {
        log.info("adicionando cargo ao usuario {} {}", nomeCargo, cpf);
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        Cargo cargo = cargoRepository.findByNome(nomeCargo);
        usuario.getCargoes().add(cargo);
    }

    @Override
    public Usuario buscaUsuario(String cpf) {
        log.info("buscando o usuario {} no banco", cpf);
        return usuarioRepository.findByCpf(cpf);
    }

    @Override
    public List<Usuario> listarUsuariosPorCargo(Cargo cargo) {
        log.info("listando os usuarios por cargo {} ", cargo);
        return usuarioRepository.findByCargoes(cargo.getNome());
    }

    @Override
    public UserDetails loadUserByUsername(String cof) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(cof);
        if(usuario == null){
            log.error("usuario não encontrado");
            throw new UsernameNotFoundException("usuario não encontrado");
        }
        Collection<SimpleGrantedAuthority> autoridades = new ArrayList<>();
        usuario.getCargoes().forEach(cargo -> autoridades.add(new SimpleGrantedAuthority(cargo.getNome())));
        return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha(), autoridades);
    }
}

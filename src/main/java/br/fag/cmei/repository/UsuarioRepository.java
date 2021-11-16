package br.fag.cmei.repository;

import br.fag.cmei.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpf(String cpf);

    Usuario findByEmail(String email);

    List<Usuario> findByCargoes(String cargo);
}
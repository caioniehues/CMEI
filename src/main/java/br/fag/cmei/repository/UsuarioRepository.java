package br.fag.cmei.repository;

import br.fag.cmei.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    Usuario buscarPorCpf(@Param("cpf") String cpf);
}
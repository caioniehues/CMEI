package br.fag.cmei.repository;

import br.fag.cmei.entidades.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findByNome(String nome);
}
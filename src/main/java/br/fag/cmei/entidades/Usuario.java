package br.fag.cmei.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_USUARIO")
    @SequenceGenerator(name = "GEN_ID_USUARIO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_cargos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "cargos_id"))
    private Collection<Cargo> cargoes;

}
package br.fag.cmei.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "usuario_diretor")
@Entity
public class UsuarioDiretor
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_DIRETOR")
    @SequenceGenerator(name = "GEN_ID_DIRETOR", sequenceName = "ID_DIRETOR", allocationSize = 1)
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


}
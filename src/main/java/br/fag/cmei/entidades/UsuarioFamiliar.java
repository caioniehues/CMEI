package br.fag.cmei.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "usuario_familiar")
@Entity
public class UsuarioFamiliar
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_FAMILIAR")
    @SequenceGenerator(name = "GEN_ID_FAMILIAR", allocationSize = 1)
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
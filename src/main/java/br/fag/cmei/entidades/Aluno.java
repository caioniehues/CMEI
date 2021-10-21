package br.fag.cmei.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "aluno")
@Entity
public class Aluno
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_ALUNO")
    @SequenceGenerator(name = "GEN_ID_ALUNO", sequenceName = "ID_ALUNO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;


}
package br.fag.cmei.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "turma")
@Entity
public class Turma
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_TURMA")
    @SequenceGenerator(name = "GEN_ID_TURMA", sequenceName = "ID_TURMA", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;


}
package br.fag.cmei.entidades;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.dto.UsuarioVinculadoDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cadastrado")
    private boolean cadastrado;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private UserRoles userRoles;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @Column(name = "plantao")
    private String plantao;

    @Column(name = "telefone")
    private String telefone;

    public Usuario(UsuarioVinculadoDTO usuarioVinculadoDTO) {
        this.nome = usuarioVinculadoDTO.getNome();
        this.email = usuarioVinculadoDTO.getEmail();
        this.cpf = usuarioVinculadoDTO.getCpf();
        this.userRoles = usuarioVinculadoDTO.getUserRoles();
        this.cadastrado = false;
        this.telefone = usuarioVinculadoDTO.getTelefone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
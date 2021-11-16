package br.fag.cmei.config;



import com.google.common.collect.Sets;

import java.util.Set;

public enum UserRoles {

    DIRETOR(Sets.newHashSet(UserPermit.DIRETOR_READ, UserPermit.DIRETOR_WRITE, UserPermit.COORDENADOR_READ, UserPermit.COORDENADOR_WRITE, UserPermit.SECRETARIO_READ, UserPermit.SECRETARIO_WRITE, UserPermit.PROFESSOR_READ, UserPermit.PROFESSOR_WRITE)),
    COORDENADOR(Sets.newHashSet(UserPermit.COORDENADOR_READ, UserPermit.COORDENADOR_WRITE, UserPermit.SECRETARIO_READ, UserPermit.SECRETARIO_WRITE, UserPermit.PROFESSOR_READ, UserPermit.PROFESSOR_WRITE)),
    SECRETARIO(Sets.newHashSet(UserPermit.SECRETARIO_WRITE, UserPermit.SECRETARIO_READ, UserPermit.PROFESSOR_WRITE, UserPermit.PROFESSOR_READ)),
    PROFESSOR(Sets.newHashSet(UserPermit.PROFESSOR_READ, UserPermit.PROFESSOR_WRITE));

    private final Set<UserPermit> permissoes;

    UserRoles(Set<UserPermit> permissoes) {
        this.permissoes = permissoes;
    }

    public Set<UserPermit> getPermissoes() {
        return permissoes;
    }
}

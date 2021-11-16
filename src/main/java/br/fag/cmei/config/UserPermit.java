package br.fag.cmei.config;

public enum UserPermit {
    DIRETOR_READ("diretor:read"),
        DIRETOR_WRITE("diretor:write"),
            COORDENADOR_READ("coordenador:read"),
                COORDENADOR_WRITE("coordenador:write"),
                    SECRETARIO_READ("secretario:read"),
                        SECRETARIO_WRITE("secretario:write"),
                            PROFESSOR_READ("professor:read"),
                                PROFESSOR_WRITE("professor:write");

    private final String permissao;

    UserPermit(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
}

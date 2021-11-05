package br.fag.cmei.model;

import org.springframework.security.core.GrantedAuthority;

public class Autoridade implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "ADMIN";
    }
}

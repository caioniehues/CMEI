package br.fag.cmei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    @RequestMapping(value = "/login")
    public String rendenizarLogin(){
        return "login";
    }

    @RequestMapping(value = "cadastro")
    public String rendenizarCadastro(){
        return "cadastro";
    }
}

package br.fag.cmei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroController
{
    @RequestMapping(value = "/")
    public String abreCadastro(){
        return "cadastro";
    }
}

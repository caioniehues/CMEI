package br.fag.cmei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavBarController {

    @RequestMapping(value = "/consultar_coordenacao")
    public String redenizarConsultaCoordenacao(){
        return "consultar_coordenacao";
    }

    @RequestMapping(value = "/consultar_secretaria")
    public String redenizarConsultaSecretaria(){
        return "consultar_secretaria";
    }

    @RequestMapping(value = "/consultar_professores")
    public String redenizarConsultaProfessores(){
        return "consultar_professores";
    }
}

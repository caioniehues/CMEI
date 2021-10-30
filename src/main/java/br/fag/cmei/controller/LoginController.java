package br.fag.cmei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    @RequestMapping(value = "/logar")
    public String abreLogin(){
        return "logar";
    }

//    @RequestMapping(value = "/error")
//    public String error(){
//        return "adc_turma";
//    }
}

package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
    @GetMapping(value = "/login")
    public ModelAndView rendenizarLogin(){
        return new ModelAndView("login", "usuario", new UsuarioDTO());
    }

    @RequestMapping(value = "/login/cadastro")
    public ModelAndView rendenizarCadastro(){
        return new ModelAndView("cadastro", "usuario", new UsuarioDTO());
    }

    @GetMapping(value = "/perfil")
    public String rendenizaPerfil(){
        return "perfil";
    }
}

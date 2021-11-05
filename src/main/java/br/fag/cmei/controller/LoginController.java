package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
    @RequestMapping(value = "/login")
    public ModelAndView rendenizarLogin(){
        return new ModelAndView("login", "usuario", new UsuarioDTO());
    }

    @RequestMapping(value = "/login/cadastro")
    public ModelAndView rendenizarCadastro(){
        return new ModelAndView("cadastro", "usuario", new UsuarioDTO());
    }
}

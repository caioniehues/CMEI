package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CadastroController
{
    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping(value = "/")
    public String rendenizarCadastro(WebRequest webRequest, Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "cadastro";
    }

    @RequestMapping(value = "perfil")
    public ModelAndView realizarCadastroUsuario(@ModelAttribute("usuario") @Valid UsuarioDTO usuario,
                                                HttpServletRequest request, Errors errors){

        Usuario registrado = UsuarioService.cadastrarNovoUsuario(usuario);

        return new ModelAndView("perfil", "usuario", usuario);
    }
}

package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.repository.UsuarioRepository;
import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LoginController
{
    private final UsuarioServiceImpl usuarioService;
    private final UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/login")
    public String rendenizarLogin() throws Exception {
        return  "login";
    }

    @RequestMapping(value = "/login/cadastro")
    public ModelAndView rendenizarCadastro(){
        return new ModelAndView("cadastro", "usuario", new UsuarioCadastroDTO());
    }

    @GetMapping(value = "/perfil")
    public String rendenizaPerfil(){
        return "perfil";
    }
}

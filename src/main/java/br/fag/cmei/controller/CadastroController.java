package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CadastroController
{
    @Autowired
    private UsuarioServiceImpl UsuarioServiceIMp;

    @RequestMapping(value = "/cadastro")
    public ModelAndView rendenizarCadastro(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        return new ModelAndView("cadastro", "usuario", usuarioDTO);
    }

    @PostMapping(value = "/cadastro/registrar")
    public ModelAndView realizarCadastroUsuario(@ModelAttribute("usuario") @Valid UsuarioDTO usuario,
                                                HttpServletRequest request, Errors errors) throws Exception {

            Usuario registrado = UsuarioServiceIMp.saveUsuario(usuario);

        return new ModelAndView("perfil", "usuario", registrado);
    }
}

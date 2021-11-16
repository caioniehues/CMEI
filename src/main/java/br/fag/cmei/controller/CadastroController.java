package br.fag.cmei.controller;

import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private UsuarioServiceImpl usuarioServiceIMp;

    @RequestMapping(value = "/cadastro")
    public ModelAndView rendenizarCadastro(){
        UsuarioCadastroDTO usuarioCadastroDTO = new UsuarioCadastroDTO();

        return new ModelAndView("cadastro", "usuario", usuarioCadastroDTO);
    }

    @PostMapping(value = "/registrar")
    public ModelAndView realizarCadastroUsuario(@ModelAttribute("usuario") @Valid UsuarioCadastroDTO usuario,
                                                HttpServletRequest request, Errors errors) throws Exception {

            Usuario registrado = usuarioServiceIMp.buscaUsuario(usuario.getCpf());

            registrado.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
           registrado.setCadastrado(true);
            usuarioServiceIMp.savaUsuario(registrado);

        return new ModelAndView("perfil", "usuario", registrado);
    }
}

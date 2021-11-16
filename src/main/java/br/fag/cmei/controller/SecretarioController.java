package br.fag.cmei.controller;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.dto.UsuarioVinculadoDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class SecretarioController {

    private final UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/consultar_secretaria")
    public ModelAndView redenizarConsultaSecretaria(){
        List<Usuario> secretariosCadastrados = usuarioService.buscarPorCargo(UserRoles.SECRETARIO);
        return new ModelAndView("consultar_secretaria", "lista_secretarios", secretariosCadastrados) ;
    }

    @RequestMapping(value = "/adicionar_secretaria")
    public ModelAndView rendenizaAdicionarSecretaria(){

        return new ModelAndView("adicionar_secretaria", "secretaria", new UsuarioVinculadoDTO());
    }



    @RequestMapping(value = "vincular_secretaria")
    public ModelAndView vinculaSecretaria(@ModelAttribute("secretaria") @Valid UsuarioVinculadoDTO secretaria,
                                           HttpServletRequest request, Errors errors) throws Exception {

        secretaria.setUserRoles(UserRoles.COORDENADOR);
        Usuario registrado = usuarioService.saveUsuario(secretaria);
        return new ModelAndView("consultar_secretaria", "usuario", registrado);
    }
}

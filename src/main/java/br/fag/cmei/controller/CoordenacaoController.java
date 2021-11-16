package br.fag.cmei.controller;

import br.fag.cmei.config.UserRoles;
import br.fag.cmei.dto.UsuarioCadastroDTO;
import br.fag.cmei.dto.UsuarioVinculadoDTO;
import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class CoordenacaoController {

    private final UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/consultar_coordenacao")
    public ModelAndView redenizarConsultaCoordenacao(){
        List<Usuario> coordenadoresCadastrados = usuarioService.buscarPorCargo(UserRoles.COORDENADOR);
        return new ModelAndView("consultar_coordenacao", "lista_coordenadores", coordenadoresCadastrados) ;
    }

    @RequestMapping(value = "/adicionar_coordenacao")
    public ModelAndView rendenizaAdicionarCoordenacao(){

        return new ModelAndView("adicionar_coordenacao", "coordenador", new UsuarioVinculadoDTO());
    }

    public String rendenizaArquivarCoordenacao(){
        return  "";
    }

    @RequestMapping(value = "vincular_coordenador")
    public ModelAndView vinculaCoordenador(@ModelAttribute("coordenador") @Valid UsuarioVinculadoDTO coordenador,
                                      HttpServletRequest request, Errors errors) throws Exception {

        coordenador.setUserRoles(UserRoles.COORDENADOR);
        Usuario registrado = usuarioService.saveUsuario(coordenador);
        return new ModelAndView("consultar_coordenacao", "usuario", registrado);
    }

    @RequestMapping(value = "arquivar_coordenador")
    public ModelAndView arquivarCoordenador(@ModelAttribute("coordenador") Usuario usuario) {
        return new ModelAndView("arquivar_coordenacao", "coordenador_arquivamento", usuario);
    }


}

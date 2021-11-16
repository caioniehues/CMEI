package br.fag.cmei.utils.validador;

import br.fag.cmei.entidades.Usuario;
import br.fag.cmei.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorCpfVinculado implements ConstraintValidator<CpfVinculado, String> {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public void initialize(CpfVinculado constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Usuario usuario = usuarioService.buscaUsuario(s);
        if(usuario == null){
            return false;
        } else {
            return true;
        }

    }
}

package br.fag.cmei.utils.validador;

import br.fag.cmei.dto.UsuarioCadastroDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorSenha implements ConstraintValidator<SenhaValida, Object> {
    @Override
    public void initialize(SenhaValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        UsuarioCadastroDTO usuario = (UsuarioCadastroDTO) object;
        return usuario.getSenha().equals(usuario.getConfirmaSenha());
    }
}


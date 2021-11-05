package br.fag.cmei.utils.validador;





import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorSenha.class)
@Documented
public @interface SenhaValida {
    String message() default "As senhas não são iguais!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

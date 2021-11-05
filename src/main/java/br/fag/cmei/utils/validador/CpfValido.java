package br.fag.cmei.utils.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorCpf.class)
@Documented
public @interface CpfValido {
    String message() default "CPF Inválido! ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

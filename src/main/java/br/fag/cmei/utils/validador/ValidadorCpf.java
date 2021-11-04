package br.fag.cmei.utils.validador;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorCpf  implements ConstraintValidator<CpfValido, String> {
    @Override
    public void initialize(CpfValido constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return validarCpf(cpf);
    }

    public boolean validarCpf(String cpf){
        String[] array = cpf.split("");
        int somaValidacaoPrimeiroDigito = 0;
        int coeficienteValidacaoPrimeiroDigito = 10;
        int somaVlidacaoSegundoDigito = 0;
        int coeficienteValidacaoSegundoDigito = 11;
        boolean verificacaoPrimeiroDigito = false;
        boolean verificacaoSegundoDigito = false;
        for(int i=0; i<8; i++){
            int n = Integer.parseInt(array[i]);
            somaValidacaoPrimeiroDigito = somaValidacaoPrimeiroDigito + n * (coeficienteValidacaoPrimeiroDigito - i);
        }

        if(somaValidacaoPrimeiroDigito * 10 % 11 == Integer.parseInt(array[11])){
            verificacaoPrimeiroDigito = true;
        }

        for(int i=0; i<9; i++){
            int n = Integer.parseInt(array[i]);
            somaVlidacaoSegundoDigito = somaVlidacaoSegundoDigito + n * (coeficienteValidacaoSegundoDigito - i);
            if(i == 8){
                somaVlidacaoSegundoDigito += Integer.parseInt(array[11]);
            }
        }

        if(somaVlidacaoSegundoDigito * 10 % 11 == Integer.parseInt(array[12])){
            verificacaoSegundoDigito = true;
        }

        return verificacaoPrimeiroDigito == verificacaoSegundoDigito;
    }
}

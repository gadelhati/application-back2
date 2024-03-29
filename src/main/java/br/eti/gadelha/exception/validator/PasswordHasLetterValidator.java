package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.PasswordHasLetter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordHasLetterValidator implements ConstraintValidator<PasswordHasLetter, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        for (char c : value.toCharArray()) {
            if (Character.isLetter(c)) {
                validator = true;
            }
        }
        return validator;
    }
}
package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueUserName;
import br.eti.gadelha.services.ServiceRole;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    private ServiceUser serviceUser;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceUser.existsByName(value);
    }
}
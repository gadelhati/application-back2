package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTTTTdTdTd;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTTTTdTdTdValidator implements ConstraintValidator<ValidTTTTdTdTd, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTTTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getTtt() !=null && !value.getTtt().equals("///")
                && value.getTdtdtd() != null && !value.getTdtdtd().equals("///")
                && Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTdtdtd()) ) {
            return false;
        } else {
            return true;
        }
    }
}
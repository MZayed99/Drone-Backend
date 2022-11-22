package com.example.dronebackend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MedicationNameValidator implements ConstraintValidator<MedicationNameConstraint,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        boolean valid = s.matches("[a-zA-Z0-9-_]*");
        return valid;
    }
}

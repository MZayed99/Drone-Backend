package com.example.dronebackend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MedicationCodeValidator implements ConstraintValidator<MedicationCode,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    final String regex = "[a-zA-Z0-9-_]*";
    boolean valid = s.matches(regex);
       return valid ;


    }
}

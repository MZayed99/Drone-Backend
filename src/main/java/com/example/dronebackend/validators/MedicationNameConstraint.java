package com.example.dronebackend.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MedicationNameValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MedicationNameConstraint {

    String message() default "medication name can be only Characters or numbers - _";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

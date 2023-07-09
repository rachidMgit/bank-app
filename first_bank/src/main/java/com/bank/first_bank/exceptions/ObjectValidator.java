package com.bank.first_bank.exceptions;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class ObjectValidator<T> {

    public final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    private final Validator validator= factory.getValidator();
    public void validate (T objectToValidate){
        Set<ConstraintViolation<T>> violationSet =validator.validate(objectToValidate);
        if(!violationSet.isEmpty()){
            Set<String> errorMessages = violationSet.stream()
                    .map(violation-> violation.getMessage())
                    .collect(Collectors.toSet());
            // todo raise an exception
            throw  new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
        }

    }



}

package com.bank.first_bank.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException{

    private final Set<String> violatons;
    private final String violationSource;

}

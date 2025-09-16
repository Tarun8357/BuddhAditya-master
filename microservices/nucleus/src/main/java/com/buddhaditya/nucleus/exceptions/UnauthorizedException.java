package com.buddhaditya.nucleus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.UNAUTHORIZED;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends NucleusException {
    public UnauthorizedException(String message) {
        super(message, UNAUTHORIZED);
    }
}
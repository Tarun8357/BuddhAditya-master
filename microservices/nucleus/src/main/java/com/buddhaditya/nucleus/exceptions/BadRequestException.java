package com.buddhaditya.nucleus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.BAD_REQUEST;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends NucleusException {
    public BadRequestException(String message) {
        super(message, BAD_REQUEST);
    }
}

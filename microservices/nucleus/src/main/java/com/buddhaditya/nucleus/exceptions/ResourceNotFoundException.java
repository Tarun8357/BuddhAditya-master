package com.buddhaditya.nucleus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.RESOURCE_NOT_FOUND;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends NucleusException {
    public ResourceNotFoundException(String message) {
        super(message, RESOURCE_NOT_FOUND);
    }
}

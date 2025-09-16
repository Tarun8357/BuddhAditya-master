package com.buddhaditya.nucleus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.BAD_REQUEST;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.ERROR;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.FORBIDDEN;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.MESSAGE;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.RESOURCE_NOT_FOUND;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.TIMESTAMP;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.UNAUTHORIZED;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NucleusException.class)
    public ResponseEntity<Map<String, Object>> handleNucleusException(NucleusException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP, Instant.now());
        body.put(ERROR, ex.getErrorCode());
        body.put(MESSAGE, ex.getMessage());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        switch (ex.getErrorCode()) {
            case BAD_REQUEST -> status = HttpStatus.BAD_REQUEST;
            case RESOURCE_NOT_FOUND -> status = HttpStatus.NOT_FOUND;
            case UNAUTHORIZED -> status = HttpStatus.UNAUTHORIZED;
            case FORBIDDEN -> status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<>(body, status);
    }
}

package com.buddhaditya.nucleus.exceptions;

import com.buddhaditya.nucleus.dtos.ErrorResponse;
import com.buddhaditya.nucleus.logging.NucleusLogger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.BAD_REQUEST;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.EXCEPTION_CAUGHT_MESSAGE;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.FORBIDDEN;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.RESOURCE_NOT_FOUND;
import static com.buddhaditya.nucleus.constants.exceptionconstants.ExceptionConstants.UNAUTHORIZED;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final NucleusLogger log = NucleusLogger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NucleusException.class)
    public ResponseEntity<ErrorResponse> handleNucleusException(NucleusException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        switch (ex.getErrorCode()) {
            case BAD_REQUEST -> status = HttpStatus.BAD_REQUEST;
            case RESOURCE_NOT_FOUND -> status = HttpStatus.NOT_FOUND;
            case UNAUTHORIZED -> status = HttpStatus.UNAUTHORIZED;
            case FORBIDDEN -> status = HttpStatus.FORBIDDEN;
        }

        // Log error message and stacktrace to terminal
        log.error(EXCEPTION_CAUGHT_MESSAGE, ex.getErrorCode(), ex.getMessage(), ex);

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(Instant.now())
                .statusCode(status.value())
                .error(ex.getErrorCode())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, status);
    }
}

package com.buddhaditya.nucleus.exceptions;

public abstract class NucleusException extends RuntimeException {
    private final String errorCode;

    public NucleusException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

package com.FundooNotesApp.exception;

public class FundooAppException extends RuntimeException {
    public FundooAppException(String message) {
        super(message);
    }

    public FundooAppException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.gmail.eugene.travelbot.web.exception;

public class WebException extends RuntimeException {
    public WebException(String message, Throwable cause) {
        super(message, cause);
    }
}

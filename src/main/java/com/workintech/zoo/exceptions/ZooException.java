package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

public class ZooException extends java.lang.RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public ZooException(String message,
                        HttpStatus httpStatus) {

        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
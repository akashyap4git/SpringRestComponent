package com.ak4.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppWebApplicationException extends Exception {

    public AppWebApplicationException(String s) {
        super(s);
    }
}

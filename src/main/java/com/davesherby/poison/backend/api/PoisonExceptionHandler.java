package com.davesherby.poison.backend.api;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PoisonExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    	HttpHeaders respHeaders = new HttpHeaders();
    	respHeaders.add("cause", "READ the api man !!! :-)");
        return handleExceptionInternal(ex, ExceptionUtils.getStackTrace(ex), 
          respHeaders, HttpStatus.BAD_REQUEST, request);
    }
}

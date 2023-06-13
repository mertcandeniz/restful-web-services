package com.mertcandeniz.restfullwebservices.restfullwebservices.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

        ExeptionResponse exeptionResponse = new ExeptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

       return new ResponseEntity(exeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

           ExeptionResponse exeptionResponse = new ExeptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(exeptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ExeptionResponse exeptionResponse = new ExeptionResponse(new Date(), "Validation failed. Lütfen en az iki harfli bir isim giriniz !",
                ex.getBindingResult().toString());

        return new ResponseEntity(exeptionResponse, HttpStatus.BAD_REQUEST);
    }

}

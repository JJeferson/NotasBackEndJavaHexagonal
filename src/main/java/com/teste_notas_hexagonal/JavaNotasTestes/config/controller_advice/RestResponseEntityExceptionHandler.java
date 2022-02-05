package com.teste_notas_hexagonal.JavaNotasTestes.config.controller_advice;

import com.teste_notas_hexagonal.JavaNotasTestes.config.controller_advice.exceptions.BadGatewayException;
import com.teste_notas_hexagonal.JavaNotasTestes.config.controller_advice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";


    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BadGatewayException.class)
    public final ResponseEntity<Object> handleBadGatewayException(BadGatewayException ex) {
        Map<String, String> errors = createResponse(HttpStatus.BAD_GATEWAY.value(),
                "Bad Gateway",
                ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_GATEWAY);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        Map<String, String> errors = createResponse(HttpStatus.NOT_FOUND.value(), "NOT FOUND", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public final ResponseEntity<Object> handleInternalServerErrorException(HttpServerErrorException.InternalServerError ex) {
        Map<String, String> errors = createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public final ResponseEntity<Object> handleBadRequestException(HttpClientErrorException.BadRequest ex) {
        Map<String, String> errors = createResponse(HttpStatus.BAD_REQUEST.value(), "BAD REQUEST", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public final ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        Map<String, String> errors = createResponse(HttpStatus.UNAUTHORIZED.value(), "UNAUTHORIZED", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public final ResponseEntity<Object> handleNoSuchAlgorithmException(Exception ex) {
        Map<String, String> errors = createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(KeyManagementException.class)
    public final ResponseEntity<Object> handleKeyManagementException(KeyManagementException ex) {
        Map<String, String> errors = createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(KeyStoreException.class)
    public final ResponseEntity<Object> handleKeyStoreException(KeyStoreException ex) {
        Map<String, String> errors = createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        Map<String, String> errors = createResponse(HttpStatus.BAD_REQUEST.value(), "BAD REQUEST", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public final Map<String, String> createResponse(int status, String error, String message) {
        Map<String, String> errors = new HashMap<>();
        errors.put("timestamp", Clock.systemUTC().instant().toString());
        errors.put("status", String.valueOf(status));
        errors.put("error", error);
        errors.put("message", message);
        return errors;
    }

}

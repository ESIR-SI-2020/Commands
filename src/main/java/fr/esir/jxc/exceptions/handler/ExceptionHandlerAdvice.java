package fr.esir.jxc.exceptions.handler;

import fr.esir.jxc.exceptions.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity handleResourceException(ResourceException e) {
        // TODO système de log des exceptions
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        // TODO système de log des exceptions
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }
}
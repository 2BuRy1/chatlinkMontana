package user_service.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import user_service.exceptions.BadRequestException;

@ControllerAdvice
public class ExceptionApiHandler {

    @Autowired
    private Logger logger;


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(Exception ex) {
        logger.warning("Unauthorized User or invalid credentials");
        return ResponseEntity.status(400).body("Cant find or register user");
    }

}

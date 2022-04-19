/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.handler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author ds010102
 */

@RestControllerAdvice
public class ApplicationHandler {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST) 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> notValiedExeption(MethodArgumentNotValidException ex){
        System.out.println("patito");
        Map<String,String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e->{
                    errores.put(e.getField(), e.getDefaultMessage());
        });
        return errores;
    }
    
    
     @ResponseStatus(HttpStatus.NOT_FOUND) 
    @ExceptionHandler(ClaseNoEncontrada.class)
    public Map<String,Object> noEncontrada(ClaseNoEncontrada ex){
        System.out.println("patito");
        Map<String,Object> errores = new HashMap<>();
        errores.put("mensaje", ex.getMessage());
        errores.put("otros", ex.otros);
        return errores;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.controller;

import com.finsol.springvalidation.dto.ClaseRequest;
import com.finsol.springvalidation.entity.Clase;
import com.finsol.springvalidation.handler.ClaseNoEncontrada;
import com.finsol.springvalidation.repository.ClaseRepository;
import com.finsol.springvalidation.service.ClaseService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ds010102
 */
@RestController
@RequiredArgsConstructor
public class ClaseController {
  private final ClaseService service;
    
    @GetMapping(value="/listado")
    public ResponseEntity<List<Clase>> listado(){       
        return ResponseEntity.ok(service.obtenerClases());        
    }
    
    @PostMapping(value = "/guardar")
    public ResponseEntity<Clase> guardarClase(@RequestBody @Valid ClaseRequest clase){
        System.out.println(clase.toString());
        return new ResponseEntity<>(service.saveClase(clase),HttpStatus.CREATED);
    }
    
    @GetMapping(value="/obtener/{id}")
    public ResponseEntity<Clase> obtenerClase(@PathVariable Integer id) throws ClaseNoEncontrada{
        return ResponseEntity.ok(service.obtenerClase(id));
    }
    
}

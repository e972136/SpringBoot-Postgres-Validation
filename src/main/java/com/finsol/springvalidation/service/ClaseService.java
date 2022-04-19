/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.service;

import com.finsol.springvalidation.dto.ClaseRequest;
import com.finsol.springvalidation.entity.Clase;
import com.finsol.springvalidation.handler.ClaseNoEncontrada;
import com.finsol.springvalidation.repository.ClaseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ds010102
 */

@Service
@RequiredArgsConstructor
public class ClaseService {
    private final ClaseRepository repository;
    
    public List<Clase> obtenerClases(){
        return repository.findAll();
    }
    
    public Clase saveClase(ClaseRequest nuevo){
        Clase nueva = Clase.of(null, nuevo.getClase_nombre(),nuevo.getClase_email(),nuevo.getClase_unidades());
        return repository.save(nueva);
    }
    
    public Clase obtenerClase(Integer id) throws ClaseNoEncontrada{
        Clase clase = repository.findById(id).orElse(null);
        List<String> tmp = List.of("a","b","c");
        if(clase!=null){
            return clase;
        }else{
            throw new ClaseNoEncontrada("Usuario "+id+" no existe",tmp);
        }
         
    }
}

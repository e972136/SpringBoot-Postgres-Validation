/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ds010102
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ClaseRequest {
    @NotNull(message = "Falta nombre")
    String clase_nombre;
    
    @Email
    String clase_email;
    
    @Min(1)
    @Max(5)
    Integer clase_unidades;   
    
}

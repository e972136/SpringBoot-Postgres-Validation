/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ds010102
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    Integer clase_Id;
    String clase_nombre;
    String clase_email;
    Integer clase_unidades;
}

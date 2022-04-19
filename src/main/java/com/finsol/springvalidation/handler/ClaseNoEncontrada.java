/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finsol.springvalidation.handler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ds010102
 */
public class ClaseNoEncontrada extends Exception{

    List<String> otros;
    public ClaseNoEncontrada(String message,List<String> otros) {
        super(message);
        this.otros = otros;
    }
    
}

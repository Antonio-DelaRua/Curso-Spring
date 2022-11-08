package com.ruxx;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public Calculadora(){
        System.out.println("probando constructor calculatorService");
    }
    public String holamundo(){
        return "hola mundo!";
    }
}

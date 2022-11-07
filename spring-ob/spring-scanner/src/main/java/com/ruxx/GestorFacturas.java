package com.ruxx;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    // 1 . atributos
    Calculadora calculadora;

    // 2. constructores
    public GestorFacturas(Calculadora calculadora){
        System.out.println("ejecutando constructor de gestor de facturas");
        this.calculadora = calculadora;

    }

    // 3 . metodos
}

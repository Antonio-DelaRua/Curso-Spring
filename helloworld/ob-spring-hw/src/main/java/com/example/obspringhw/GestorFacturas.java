package com.example.obspringhw;

public class GestorFacturas {

    // 1 . atributos
    Calculadora calculadora;
    String nombre;

    // 2. constructores
    public GestorFacturas(Calculadora calculadora, String nombre){
        System.out.println("ejecutando constructor de gestor de facturas");
        this.calculadora = calculadora;
        this.nombre = nombre;
    }

    // 3 . metodos
}

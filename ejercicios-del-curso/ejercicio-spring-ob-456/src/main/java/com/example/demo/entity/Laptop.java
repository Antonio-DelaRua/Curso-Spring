package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordenadores")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String modelo;
    private Double precio;
    private Boolean enstock;

    public Laptop() {
    }

    public Laptop(Long id, String modelo, Double precio, Boolean enstock) {
        this.id = id;
        this.modelo = modelo;
        this.precio = precio;
        this.enstock = enstock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEnstock() {
        return enstock;
    }

    public void setEnstock(Boolean enstock) {
        this.enstock = enstock;
    }
}

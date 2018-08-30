package com.example.joseenrique.anothersampledager.models;

import javax.inject.Inject;

public class Carro {

    private String marca;
    private String modelo;
    private int year;

    //Dependency
    Llantas llantas;


    public Carro() {

    }

    public Carro(String marca, String modelo, int year,Llantas llantas) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.llantas = llantas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

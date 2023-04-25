package com.example.parcialprimercorte;

import java.io.Serializable;
public class datos implements Serializable {

    private String nombre;
    private String ciudad;


    datos() {
        this.nombre="";
        this.ciudad="";

    }
    datos(String nombre, String ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getCiudad() {

        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

}


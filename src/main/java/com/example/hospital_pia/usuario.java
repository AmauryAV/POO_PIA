package com.example.hospital_pia;

import enums.Tipo_usuario;

public class usuario {
    private int id;
    private String nombre;
    private String contra;
    private Tipo_usuario tipo;

    public usuario(int id, String nombre, String contra, Tipo_usuario tipo) {
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}

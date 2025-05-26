package com.example.hospital_pia;

import enums.Tipo_usuario;
import jakarta.persistence.*;


@Entity
@Table(name = "USUARIOS")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Column(name = "contrasena")
    private String contra;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private Tipo_usuario tipo;

    public usuario() {}

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

    public Tipo_usuario getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_usuario tipo) {
        this.tipo = tipo;
    }
}

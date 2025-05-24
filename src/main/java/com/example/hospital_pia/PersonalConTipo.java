package com.example.hospital_pia;

import enums.Tipo_usuario;

public class PersonalConTipo {
    private personal personal;
    private Tipo_usuario tipo;

    public PersonalConTipo(personal personal, Tipo_usuario tipo) {
        this.personal = personal;
        this.tipo = tipo;
    }

    public personal getPersonal() {
        return personal;
    }

    public Tipo_usuario getTipo() {
        return tipo;
    }
}

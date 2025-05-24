package com.example.hospital_pia;

public class administrador extends personal{


    public administrador(String nombre, String apellido_paterno, String apellido_materno,
                         String direccion, String telefono, String correo, usuario usu) {
        super(nombre, apellido_paterno, apellido_materno, direccion, telefono, correo, usu);
    }

    public void agregar_doctor (doctor doc, hospital hosp) {
        hosp.anadir_doctor(doc);
    }

    public void anadir_enfermero (enfermero enfermero, hospital hosp) {
        hosp.anadir_enfermero(enfermero);
    }

    public void anadir_administrador(administrador administrador, hospital hosp) {
        hosp.anadir_administrador(administrador);
    }

    @Override
    public String nombreCompleto() {
        return "";
    }

    @Override
    public void mostrar_informacion() {

    }


}

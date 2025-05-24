package com.example.hospital_pia;

import java.util.ArrayList;
import java.util.List;

public class doctor extends personal {

    String especialidad;
    List<historial_clinico> historial_clinicos;
    List<receta_paciente> recetas_emitidas;

    public doctor(String nombre, String apellido_paterno, String apellido_materno, String direccion,
                  String telefono, String correo, usuario usu, String especialidad) {
        super(nombre, apellido_paterno, apellido_materno, direccion, telefono, correo, usu);
        this.especialidad = especialidad;
        this.historial_clinicos = new ArrayList<historial_clinico>();
        this.recetas_emitidas = new ArrayList<>();
    }

    @Override
    public String nombreCompleto() {
        return this.nombre+" "+this.apellido_paterno+" "+this.apellido_materno;
    }

    @Override
    public void mostrar_informacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido paterno: "+this.apellido_paterno);
        System.out.println("Apellido materno: "+this.apellido_materno);
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Correo: "+this.correo);

    }

    public void agregar_historial_clinico(historial_clinico historial) {
        historial_clinicos.add(historial);
    }

    public void agregar_receta_paciente(receta_paciente receta) {
        recetas_emitidas.add(receta);
    }

    public void llamar_paciente(hospital hl) {
        registro_paciente rp = hl.cola_prioridad.desencolarRegistro();
    }

}

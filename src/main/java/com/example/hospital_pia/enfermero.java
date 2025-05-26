package com.example.hospital_pia;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enfermero")
public class enfermero extends personal{

    @Transient
    List<registro_paciente> pacientes;

    @Column(name= "turno")
    String turno;
    public enfermero(String nombre, String apellido_paterno, String apellido_materno,
                     String direccion, String telefono, String correo, usuario usu, String turno) {
        super(nombre, apellido_paterno, apellido_materno, direccion, telefono, correo, usu);
        this.turno = turno;
        pacientes = new ArrayList<registro_paciente>();
    }

    public enfermero() {}

    @Override
    public String nombreCompleto() {
        return this.nombre+" "+this.apellido_paterno+" "+this.apellido_materno;
    }

    @Override
    public void mostrar_informacion() {
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Apellido paterno: "+this.apellido_paterno);
        System.out.println("Apellido materno: "+this.apellido_materno);
        System.out.println("Turno: "+this.turno);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Correo: "+this.correo);
    }

    public void agregar_registro(registro_paciente paciente, hospital hosp) {
        pacientes.add(paciente);
        hosp.anadir_registro_paciente(paciente);
        hosp.registrar_paciente(paciente);
        hosp.cola_prioridad.agregarRegistro(paciente, hosp);
    }

    public void imprimir_registros() {
        for (registro_paciente paciente : pacientes) {
            System.out.println("Numero de registro: "+paciente.getNumero_registro());
            System.out.println("Nombre del paciente: " + paciente.nombre_paciente + " " + paciente.apellido_paterno_paciente + " " + paciente.apellido_materno_paciente);
            System.out.println("Fecha del registro: " + paciente.fecharegistro);
        }
    }

    public boolean estado(){
        if (this.estado == false) {
            return true;
        }
        else{
            return false;
        }
    }


}

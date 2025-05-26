package com.example.hospital_pia;

import enums.Area_medica;

import java.util.List;

public class registro_internado extends registro_base{

    String tratamiento;
    Area_medica area;
    String signos_vitales;
    String sintomas;
    String diagnostico;
    Integer id_doctor;
    Integer id_internado;
    public static Integer ids = 1;

    public registro_internado(historial_clinico historial, Area_medica area) {
        super(historial.nombre_paciente, historial.apellido_paterno_paciente, historial.apellido_materno_paciente,
                historial.direccion_paciente, historial.telefono_paciente, historial.correo_paciente,
                historial.edad_paciente, historial.sexo_paciente, historial.tipo_sangre,
                historial.alergias_paciente, historial.peso, historial.altura);
        this.area = area;
        this.tratamiento = historial.tratamiento;
        this.signos_vitales = historial.signos_vitales;
        this.sintomas = historial.sintomas;
        this.diagnostico = historial.diagnostico;
        this.id_doctor = historial.id_doctor;
        this.id_internado = ids++;
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Registro de ingreso a un area medica" + "    Fecha: " + this.fecharegistro);
        System.out.println("Area medica asignada: " + this.area);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Diagnostico: " + this.diagnostico);
        System.out.println("Tratamiento: " + this.tratamiento);
        System.out.println("Sintomas: " + this.sintomas);
    }

    public Integer getId_internado() {
        return id_internado;
    }

    public void setId_internado(Integer id_internado) {
        this.id_internado = id_internado;
    }
}

package com.example.hospital_pia;

import java.util.List;

public class historial_clinico extends registro_base{

    String tratamiento;
    List<String> medicinas;
    List<String> estudios;
    String signos_vitales;
    String sintomas;
    String diagnostico;
    boolean internado;
    boolean traslado;
    boolean alta;
    Integer id_doctor;

    public historial_clinico(String nombre_paciente, String apellido_paterno_paciente,
                             String apellido_materno_paciente, String direccion_paciente,
                             String telefono_paciente, String correo_paciente, int edad_paciente,
                             String sexo_paciente, String tipo_sangre, String alergias_paciente,
                             String tratamiento,String signos_vitales, String sintomas, String diagnostico,
                             List<String> medicinas, List<String> estudios, boolean internado, boolean traslado,
                             boolean alta, Integer id_doctor, float peso, float altura) {
        super(nombre_paciente, apellido_paterno_paciente, apellido_materno_paciente, direccion_paciente,
                telefono_paciente, correo_paciente, edad_paciente, sexo_paciente, tipo_sangre,
                alergias_paciente, peso, altura);
        this.tratamiento = tratamiento;
        this.signos_vitales = signos_vitales;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.medicinas = medicinas;
        this.estudios = estudios;
        this.internado = internado;
        this.traslado = traslado;
        this.alta = alta;
        this.id_doctor = id_doctor;
    }
    public historial_clinico(registro_paciente registro_paciente, String tratamiento,
                             String diagnostico, boolean internado, boolean traslado, boolean alta,
                             List<String> medicinas, List<String> estudios, int id_doctor, String signos) {
        super(registro_paciente.nombrepaciente, registro_paciente.apellidopaternopaciente, registro_paciente.apellidomaternopaciente,
                registro_paciente.direccion_paciente, registro_paciente.telefono_paciente, registro_paciente.correo_paciente,
                registro_paciente.edad_paciente, registro_paciente.sexo_paciente, registro_paciente.tipo_sangre,
                registro_paciente.alergias_paciente, registro_paciente.peso, registro_paciente.altura);
        this.tratamiento = tratamiento;
        this.diagnostico = diagnostico;
        this.internado = internado;
        this.traslado = traslado;
        this.alta = alta;
        this.medicinas = medicinas;
        this.estudios = estudios;
        this.signos_vitales = signos;
        this.sintomas = registro_paciente.sintomas;
        this.id_doctor = id_doctor;
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Nombre del paciente: " + this.nombrepaciente + " " + this.apellidopaternopaciente + " " + this.apellidomaternopaciente);
        System.out.println("Fecha: " + this.fecharegistro);
        System.out.println("Sintomas del paciente: " + this.sintomas);
        System.out.println("Diagnostico: " + this.diagnostico);
        for (String medicina : this.medicinas) {
            System.out.println("Medicina: " + medicina);
        }
        for (String estudio : this.estudios) {
            System.out.println("Estudio: " + estudio);
        }
        if (this.internado) {
            System.out.println("El paciente tuvo que ser internado");
        }
        else if (this.traslado && !this.internado) {
            System.out.println("El paciente tuvo que ser trasladado a otro hospital");
        }
        else if (this.alta) {
            System.out.println("El paciente se dio de alta");
        }

    }
}

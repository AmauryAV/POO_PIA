package com.example.hospital_pia;

import java.util.List;

public class traslado_paciente extends registro_base{

    String hospital_transferencia;
    String signos_vitales;
    String tratamiento;
    List<String> medicinas;
    List<String> estudios;
    String sintomas;
    String diagnostico;
    Integer id_doctor;

    public traslado_paciente(historial_clinico clinico, String hospital_transferencia ) {
        super(clinico.nombre_paciente,clinico.apellido_paterno_paciente,clinico.apellido_materno_paciente,
                clinico.direccion_paciente,clinico.telefono_paciente, clinico.correo_paciente,
                clinico.edad_paciente, clinico.sexo_paciente, clinico.tipo_sangre, clinico.alergias_paciente,
                clinico.peso, clinico.altura);
        this.hospital_transferencia = hospital_transferencia;
        this.signos_vitales = clinico.signos_vitales;
        this.tratamiento = clinico.tratamiento;
        this.medicinas = clinico.medicinas;
        this.estudios = clinico.estudios;
        this.sintomas = clinico.sintomas;
        this.diagnostico = clinico.diagnostico;
        this.id_doctor = clinico.id_doctor;
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Orden de traslado de paciente");
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Diagnostico: " + this.diagnostico);
        System.out.println("Signos vitales: " + this.signos_vitales);
        System.out.println("Tratamiento hasta el momento: " + this.tratamiento);
        System.out.println("Medicamentos suninstrados:");
        for (String medicina : this.medicinas) {
            System.out.println(medicina);
        }
    }
}

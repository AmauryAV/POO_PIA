package com.example.hospital_pia;

public class registro_defuncion extends registro_base{
    Integer id_enfermero;
    String sintomas;
    Integer id;
    public static Integer ids = 1;
    public registro_defuncion(registro_paciente paciente) {
        super(paciente.nombrepaciente, paciente.apellidopaternopaciente, paciente.apellidomaternopaciente,
                paciente.direccion_paciente, paciente.telefono_paciente, paciente.correo_paciente,
                paciente.edad_paciente, paciente.sexo_paciente, paciente.tipo_sangre, paciente.alergias_paciente,
                paciente.peso, paciente.altura);
        this.id_enfermero = paciente.id_enfermero;
        this.sintomas = paciente.sintomas;
        this.id = ids++;
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Nombre del paciente: " + this.nombrepaciente + " " + this.apellidopaternopaciente + " " + this.apellidomaternopaciente);
        System.out.println("Hora de la muerte: " + this.fecharegistro);
        System.out.println("Sintomas con los que se presento: " + this.sintomas);

    }
}

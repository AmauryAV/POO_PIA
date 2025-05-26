package com.example.hospital_pia;

import java.util.List;

public class receta_paciente extends registro_base{

    List<String> medicinas;

    public receta_paciente(historial_clinico clinico, List<String> medicinas) {
        super(clinico.nombre_paciente, clinico.apellido_paterno_paciente, clinico.getApellido_materno_paciente(),
                clinico.direccion_paciente, clinico.telefono_paciente, clinico.correo_paciente, clinico.edad_paciente,
                clinico.sexo_paciente, clinico.tipo_sangre, clinico.alergias_paciente, clinico.peso, clinico.altura);
        this.medicinas = medicinas;
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Receta emitida el :" + this.fecharegistro);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Talla: " + this.altura + "    Peso: " + this.peso + "    Edad: " + this.edad_paciente);
        for(String medicina: medicinas) {
            System.out.println(medicina);
        }

    }
}

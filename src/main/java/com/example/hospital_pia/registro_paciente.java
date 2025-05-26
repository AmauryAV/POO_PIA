package com.example.hospital_pia;

import enums.Triaje;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_paciente")
public class registro_paciente extends registro_base implements Comparable<registro_paciente> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_registro")
    Integer numero_registro;

    @Enumerated(EnumType.STRING)
    Triaje triaje;

    //public static Integer contdor_registros = 1;
    String sintomas;
    String signosvitales;
    Integer id_enfermero;


    public registro_paciente(String nombre_paciente, String apellido_paterno_paciente,
                             String apellido_materno_paciente, String direccion_paciente,
                             String telefono_paciente, String correo_paciente, int edad_paciente,
                             String sexo_paciente, String tipo_sangre, String alergias_paciente,
                             String sintomas, String signosvitales, Triaje triaje, Integer id_enfermero,
                             float peso, float altura) {
        super(nombre_paciente, apellido_paterno_paciente, apellido_materno_paciente, direccion_paciente,
                telefono_paciente, correo_paciente, edad_paciente, sexo_paciente, tipo_sangre,
                alergias_paciente,peso,altura);
        //this.numero_registro = contdor_registros++;
        this.sintomas = sintomas;
        this.signosvitales = signosvitales;
        this.triaje = triaje;
        this.id_enfermero = id_enfermero;
    }

    public registro_paciente() {}

    @PrePersist
    public void prePersist() {
        this.fecharegistro = LocalDateTime.now();
    }

    public void informacion_pantalla(){
        System.out.println("Numero de registro: " + numero_registro);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Sintomas: " + sintomas);
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Numero de registro: " + numero_registro);
        System.out.println("Fecha: " + this.fecharegistro);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Edad del paciente: " + this.edad_paciente);
        System.out.println("Sexo: " + this.sexo_paciente);
        System.out.println("Sintomas: " + sintomas);
        System.out.println("Signos vitales: " + signosvitales);
        System.out.println("Tipo de sangre: " + tipo_sangre);
        System.out.println("Color asignado en triaje: " + triaje);
    }


    @Override
    public int compareTo(registro_paciente o) {
        return Integer.compare(this.triaje.ordinal(), o.triaje.ordinal());
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getSignos_vitales() {
        return signosvitales;
    }

    public void setSignos_vitales(String signos_vitales) {
        this.signosvitales = signos_vitales;
    }

    public Integer getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(int numero_registro) {
        this.numero_registro = numero_registro;
    }

    public Triaje getTriaje() {
        return triaje;
    }

    public void setTriaje(Triaje triaje) {
        this.triaje = triaje;
    }

    public Integer getId_enfermero() {
        return id_enfermero;
    }

    public void setId_enfermero(int id_enfermero) {
        this.id_enfermero = id_enfermero;
    }

    public void setId_enfermero(Integer id_enfermero) {
        this.id_enfermero = id_enfermero;
    }
}

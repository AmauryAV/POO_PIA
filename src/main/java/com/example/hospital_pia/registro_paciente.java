package com.example.hospital_pia;

import enums.Triaje;

import java.time.LocalDate;

public class registro_paciente extends registro_base implements Comparable<registro_paciente> {

    public static Integer contdor_registros = 1;
    String sintomas;
    String signos_vitales;
    Integer numero_registro;
    Triaje triaje;
    Integer id_enfermero;
    LocalDate fecha_nacimineto;


    public registro_paciente(String nombre_paciente, String apellido_paterno_paciente,
                             String apellido_materno_paciente, String direccion_paciente,
                             String telefono_paciente, String correo_paciente, int edad_paciente,
                             String sexo_paciente, String tipo_sangre, String alergias_paciente,
                             String sintomas, String signos_vitales, Triaje triaje, Integer id_enfermero,
                             float peso, float altura, LocalDate fecha_nacimineto) {
        super(nombre_paciente, apellido_paterno_paciente, apellido_materno_paciente, direccion_paciente,
                telefono_paciente, correo_paciente, edad_paciente, sexo_paciente, tipo_sangre,
                alergias_paciente,peso,altura);
        this.numero_registro = contdor_registros++;
        this.sintomas = sintomas;
        this.signos_vitales = signos_vitales;
        this.triaje = triaje;
        this.id_enfermero = id_enfermero;
        this.fecha_nacimineto = fecha_nacimineto;
    }

    public void informacion_pantalla(){
        System.out.println("Numero de registro: " + numero_registro);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Sintomas: " + sintomas);
    }

    @Override
    void mostrar_informacion() {
        System.out.println("Numero de registro: " + numero_registro);
        System.out.println("Fecha: " + this.fecha_registro);
        System.out.println("Nombre del paciente: " + this.nombre_paciente + " " + this.apellido_paterno_paciente + " " + this.apellido_materno_paciente);
        System.out.println("Edad del paciente: " + this.edad_paciente);
        System.out.println("Sexo: " + this.sexo_paciente);
        System.out.println("Sintomas: " + sintomas);
        System.out.println("Signos vitales: " + signos_vitales);
        System.out.println("Tipo de sangre: " + tipo_sangre);
        System.out.println("Color asignado en triaje: " + triaje);
    }


    @Override
    public int compareTo(registro_paciente o) {
        return Integer.compare(this.triaje.ordinal(), o.triaje.ordinal());
    }

    public static int getContdor_registros() {
        return contdor_registros;
    }

    public static void setContdor_registros(int contdor_registros) {
        registro_paciente.contdor_registros = contdor_registros;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getSignos_vitales() {
        return signos_vitales;
    }

    public void setSignos_vitales(String signos_vitales) {
        this.signos_vitales = signos_vitales;
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

    public LocalDate getFecha_nacimineto() {
        return fecha_nacimineto;
    }

    public void setFecha_nacimineto(LocalDate fecha_nacimineto) {
        this.fecha_nacimineto = fecha_nacimineto;
    }
}

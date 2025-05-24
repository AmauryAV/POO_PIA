package com.example.hospital_pia;

import java.time.LocalDate;
import java.time.LocalDateTime;

abstract class registro_base {
    String nombre_paciente;
    String apellido_paterno_paciente;
    String apellido_materno_paciente;
    String direccion_paciente;
    String telefono_paciente;
    String correo_paciente;
    LocalDateTime fecha_registro;
    int edad_paciente;
    float peso;
    float altura;
    String sexo_paciente;
    String tipo_sangre;
    String alergias_paciente;

    public registro_base(String nombre_paciente, String apellido_paterno_paciente, String apellido_materno_paciente,
                         String direccion_paciente, String telefono_paciente, String correo_paciente,int edad_paciente,
                         String sexo_paciente, String tipo_sangre, String alergias_paciente, float peso, float altura) {
        this.nombre_paciente = nombre_paciente;
        this.apellido_paterno_paciente = apellido_paterno_paciente;
        this.apellido_materno_paciente = apellido_materno_paciente;
        this.direccion_paciente = direccion_paciente;
        this.telefono_paciente = telefono_paciente;
        this.correo_paciente = correo_paciente;
        this.edad_paciente = edad_paciente;
        this.sexo_paciente = sexo_paciente;
        this.tipo_sangre = tipo_sangre;
        this.alergias_paciente = alergias_paciente;
        this.fecha_registro = LocalDateTime.now();
        this.peso = peso;
        this.altura = altura;
    }

    abstract void mostrar_informacion();

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paterno_paciente() {
        return apellido_paterno_paciente;
    }

    public void setApellido_paterno_paciente(String apellido_paterno_paciente) {
        this.apellido_paterno_paciente = apellido_paterno_paciente;
    }

    public String getApellido_materno_paciente() {
        return apellido_materno_paciente;
    }

    public void setApellido_materno_paciente(String apellido_materno_paciente) {
        this.apellido_materno_paciente = apellido_materno_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(int edad_paciente) {
        this.edad_paciente = edad_paciente;
    }

    public String getSexo_paciente() {
        return sexo_paciente;
    }

    public void setSexo_paciente(String sexo_paciente) {
        this.sexo_paciente = sexo_paciente;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getAlergias_paciente() {
        return alergias_paciente;
    }

    public void setAlergias_paciente(String alergias_paciente) {
        this.alergias_paciente = alergias_paciente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}

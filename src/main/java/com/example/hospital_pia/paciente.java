package com.example.hospital_pia;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "paciente")
public class paciente {

    @Column(name = "nombrePaciente")
    String nombrePaciente;

    @Column(name = "apellidoPaternoPaciente")
    String apellidoPaternoPaciente;

    @Column(name = "apellidoMaternoPaciente")
    String apellidoMaternoPaciente;

    @Column(name = "direccion_paciente")
    String direccion_paciente;

    @Column(name = "telefono_pciente")
    String telefono_paciente;

    @Column(name = "correo_paciente")
    String correo_paciente;

    @Column(name = "fecha_registro")
    LocalDateTime fecha_registro;

    @Column(name = "sexo_paciente")
    String sexo_paciente;

    @Column(name = "tipo_sangre")
    String tipo_sangre;

    @Column(name = "alergias_paciente")
    String alergias_paciente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_paciente;

    @Transient
    List<registro_paciente> registro_pacientes;

    @Transient
    List<historial_clinico> historial_clinicos;
    public static Integer id_registro_paciente;

    public paciente(registro_paciente registro) {
        this.nombrePaciente = registro.getNombrepaciente();
        this.apellidoPaternoPaciente = registro.getApellidopaternopaciente();
        this.apellidoMaternoPaciente = registro.getApellidomaternopaciente();
        this.direccion_paciente = registro.getDireccion_paciente();
        this.telefono_paciente = registro.getTelefono_paciente();
        this.correo_paciente = registro.getCorreo_paciente();
        this.fecha_registro = registro.getFecha_registro();

        this.sexo_paciente = registro.getSexo_paciente();
        this.tipo_sangre = registro.getTipo_sangre();
        this.alergias_paciente = registro.getAlergias_paciente();
        this.registro_pacientes = new ArrayList<>();
        this.historial_clinicos = new ArrayList<>();

    }
    public paciente() {}

    public void imprimirDatosContacto() {
        System.out.println("Paciente: " + this.nombrePaciente + " " + this.apellidoPaternoPaciente + " " + this.apellidoMaternoPaciente);
        System.out.println("Teléfono: " + this.telefono_paciente);
        System.out.println("Correo: " + this.correo_paciente);
    }

    public void agregarRegistro(registro_paciente registro) {
        this.registro_pacientes.add(registro);
    }

    public void agregarHistorialClinic(historial_clinico historial_clinico) {
        this.historial_clinicos.add(historial_clinico);
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaternoPaciente() {
        return apellidoPaternoPaciente;
    }

    public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
    }

    public String getApellidoMaternoPaciente() {
        return apellidoMaternoPaciente;
    }

    public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
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

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public static Integer getId_registro_paciente() {
        return id_registro_paciente;
    }

    public static void setId_registro_paciente(Integer id_registro_paciente) {
        paciente.id_registro_paciente = id_registro_paciente;
    }
}

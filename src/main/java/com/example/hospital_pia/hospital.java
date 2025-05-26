package com.example.hospital_pia;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class hospital {
    public Map<Integer, registro_paciente> registros_pacientes;
    public Map<Integer, paciente> pacientes;
    public Map<Integer, registro_defuncion> defuncions;
    public Map<Integer, registro_internado> internados;
    public cola_prioridad cola_prioridad;
    public List<enfermero> enfermeros;
    public List<doctor> doctors;
    public List<administrador> administradors;

    public hospital() {
        this.registros_pacientes = new HashMap<>();
        this.pacientes = new HashMap<>();
        this.defuncions = new HashMap<>();
        this.internados = new HashMap<>();
        this.cola_prioridad = new cola_prioridad();
        this.enfermeros = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.administradors = new ArrayList<>();
    }

    public void anadir_registro_paciente(registro_paciente registro) {
        this.registros_pacientes.put(registro.getNumero_registro(), registro);
    }

    public void registrar_paciente(registro_paciente paciente){
        paciente paciente1 = verificar_registro_paciente(paciente);
        if (paciente1 != null){
            paciente paciente3 = new paciente(paciente);
            paciente3.agregarRegistro(paciente);
            pacientes.put(paciente3.id_paciente, paciente3);
        }
        else {
            actualizar_pacinete(paciente1, paciente);
        }
    }

    public void anadir_defuncion(registro_defuncion registro) {
        this.defuncions.put(registro.id, registro);
    }

    public void anadir_internado(registro_internado registro) {
        this.internados.put(registro.getId_internado(), registro);
    }

    public void anadir_enfermero(enfermero enfermero) {
        this.enfermeros.add(enfermero);
    }

    public void anadir_doctor(doctor doctor) {
        this.doctors.add(doctor);
    }

    public void anadir_administrador(administrador administrador) {
        this.administradors.add(administrador);
    }

    public paciente verificar_registro_paciente(registro_paciente registro) {
        String nombre_paciente = registro.getNombrepaciente();
        String apellido_pat = registro.getApellidopaternopaciente();
        String apellido_mater = registro.getApellidomaternopaciente();
        for (paciente paciente : pacientes.values()) {
            if (paciente.getNombrePaciente().equalsIgnoreCase(nombre_paciente) &&
            paciente.getApellidoPaternoPaciente().equalsIgnoreCase(apellido_pat) &&
            paciente.getApellidoMaternoPaciente().equalsIgnoreCase(apellido_mater)) {
                return paciente;
            }
        }
        return null;
    }

    public void actualizar_pacinete(paciente pacienteExistente, registro_paciente registro) {
        pacienteExistente.setNombrePaciente(registro.getNombrepaciente());
        pacienteExistente.setApellidoPaternoPaciente(registro.getApellidopaternopaciente());
        pacienteExistente.setApellidoMaternoPaciente(registro.getApellidomaternopaciente());
        pacienteExistente.setAlergias_paciente(registro.getAlergias_paciente());
        pacienteExistente.setCorreo_paciente(registro.getCorreo_paciente());
        pacienteExistente.setDireccion_paciente(registro.getDireccion_paciente());
        pacienteExistente.setTelefono_paciente(registro.getTelefono_paciente());
    }






    public Map<Integer, registro_paciente> getPacientes() {
        return registros_pacientes;
    }

    public void setPacientes(Map<Integer, registro_paciente> pacientes) {
        this.registros_pacientes = pacientes;
    }

    public Map<Integer, registro_defuncion> getDefuncions() {
        return defuncions;
    }

    public void setDefuncions(Map<Integer, registro_defuncion> defuncions) {
        this.defuncions = defuncions;
    }

    public Map<Integer, registro_internado> getInternados() {
        return internados;
    }

    public void setInternados(Map<Integer, registro_internado> internados) {
        this.internados = internados;
    }

    public List<administrador> getAdministradors() {
        return administradors;
    }

    public void setAdministradors(List<administrador> administradors) {
        this.administradors = administradors;
    }

    public List<doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<doctor> doctors) {
        this.doctors = doctors;
    }

    public List<enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(List<enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }
}

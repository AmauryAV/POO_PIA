package com.example.hospital_pia;

import enums.Tipo_usuario;

import java.util.HashMap;
import java.util.Map;
import enums.Tipo_usuario;
import java.util.HashMap;
import java.util.Map;

public class login {

    private Map<String, PersonalConTipo> usuariosRegistrados;

    public void Login(hospital hospital) {
        this.usuariosRegistrados = cargarUsuarios(hospital);
    }

    private Map<String, PersonalConTipo> cargarUsuarios(hospital hospital) {
        Map<String, PersonalConTipo> usuarios = new HashMap<>();

        for (administrador admin : hospital.getAdministradors()) {
            if (admin.getUsuario() != null) {
                usuarios.put(admin.getUsuario().getNombre(), new PersonalConTipo(admin, Tipo_usuario.Administrador));
            }
        }
        for (enfermero enfermero : hospital.getEnfermeros()) {
            if (enfermero.getUsuario() != null) {
                usuarios.put(enfermero.getUsuario().getNombre(), new PersonalConTipo(enfermero, Tipo_usuario.Enfermero));
            }
        }
        for (doctor doctor : hospital.getDoctors()) {
            if (doctor.getUsuario() != null) {
                usuarios.put(doctor.getUsuario().getNombre(), new PersonalConTipo(doctor, Tipo_usuario.Medico));
            }
        }
        return usuarios;
    }

    public PersonalConTipo autenticarUsuario(String nombreUsuario, String contrasena, Tipo_usuario tipoUsuario) {
        if (usuariosRegistrados.containsKey(nombreUsuario)) {
            PersonalConTipo personalConTipo = usuariosRegistrados.get(nombreUsuario);
            if (personalConTipo.getPersonal().getUsuario().getContra().equals(contrasena) && personalConTipo.getTipo() == tipoUsuario) {
                return personalConTipo;
            } else if (personalConTipo.getPersonal().getUsuario().getContra().equals(contrasena)) {
                System.out.println("Error: El tipo de usuario seleccionado no coincide con el registrado.");
            } else {
                System.out.println("Error: Contraseña incorrecta.");
            }
        } else {
            System.out.println("Error: El usuario no existe.");
        }
        return null;
    }
}




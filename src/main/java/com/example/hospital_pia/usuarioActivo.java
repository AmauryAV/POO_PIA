package com.example.hospital_pia;

public class usuarioActivo {

    private static personal persona;
    private static hospital hospital;

    public static void cerrarSesion(){
        persona = null;
    }

    public static personal getPersona() {
        return persona;
    }

    public static void setPersona(personal persona) {
        usuarioActivo.persona = persona;
    }

    public static hospital getHospital() {
        return hospital;
    }

    public static void setHospital(hospital hospital) {
        usuarioActivo.hospital = hospital;
    }
}

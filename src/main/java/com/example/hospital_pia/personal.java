package com.example.hospital_pia;

abstract class personal {
    public static Integer ids = 1;
    String nombre;
    String apellido_paterno;
    String apellido_materno;
    Integer id_empleado;
    String direccion;
    String telefono;
    String correo;
    boolean estado;
    usuario usuario;
    public personal(String nombre, String apellido_paterno, String apellido_materno, String direccion,
                    String telefono, String correo, usuario usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.id_empleado = ids++;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.estado = false;

    }
    public abstract String nombreCompleto();
    public abstract void mostrar_informacion();

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
}

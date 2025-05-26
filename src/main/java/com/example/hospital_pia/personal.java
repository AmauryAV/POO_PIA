package com.example.hospital_pia;


import jakarta.persistence.*;

@MappedSuperclass
public abstract class personal {
    public static Integer ids = 1;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellido_paterno")
    String apellido_paterno;

    @Column(name = "apellido_materno")
    String apellido_materno;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    Integer id_empleado;

    @Column(name = "direccion")
    String direccion;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "correo")
    String correo;

    @Column(name = "estado")
    boolean estado;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    usuario usuario;

    public personal(String nombre, String apellido_paterno, String apellido_materno, String direccion,
                    String telefono, String correo, usuario usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        //this.id_empleado = ids++;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.estado = false;

    }

    public personal() {}

    public abstract String nombreCompleto();
    public abstract void mostrar_informacion();

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
}

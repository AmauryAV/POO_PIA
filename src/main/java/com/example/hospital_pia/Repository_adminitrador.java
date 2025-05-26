package com.example.hospital_pia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository_adminitrador extends JpaRepository<administrador, Integer> {
    administrador findByUsuario(usuario ususarioActivo);
}

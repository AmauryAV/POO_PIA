package com.example.hospital_pia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository_doctor extends JpaRepository<doctor, Integer> {
    doctor findByUsuario(usuario ususarioActivo);
}

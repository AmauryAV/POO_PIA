package com.example.hospital_pia;


import enums.Tipo_usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository <usuario, Integer> {
    Optional<usuario> findByNombreAndContraAndTipo(String nombre, String contra, Tipo_usuario tipo);
}

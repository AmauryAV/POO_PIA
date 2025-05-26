package com.example.hospital_pia;

import enums.Triaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface Repository_registro_paciente extends JpaRepository<registro_paciente, Integer> {
    Optional<registro_paciente> findBySintomasAndSignosvitalesAndTriajeAndFecharegistro(String sintomas, String signosvitales, Triaje triaje, LocalDateTime fecha_registro);
}

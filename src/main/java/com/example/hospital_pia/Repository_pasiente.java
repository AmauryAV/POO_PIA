package com.example.hospital_pia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository_pasiente extends JpaRepository<paciente, Integer> {
}

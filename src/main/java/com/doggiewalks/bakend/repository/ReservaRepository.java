package com.doggiewalks.bakend.repository;

import com.doggiewalks.bakend.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Busca si ya existe una reserva con ese email para esa fecha
    boolean existsByEmailAndFecha(String email, LocalDate fecha);
}
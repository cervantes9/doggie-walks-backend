package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Reserva;
import com.doggiewalks.bakend.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Para ver todas las reservas (para el administrador)
    @GetMapping
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    // Para crear una reserva nueva (desde el formulario de Angular)
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva nuevaReserva) {

        // Verificamos si ya existe una reserva con ese email para esa fecha
        if (reservaRepository.existsByEmailAndFecha(nuevaReserva.getEmail(), nuevaReserva.getFecha())) {
            return ResponseEntity
                    .status(409)
                    .body("Ya existe una reserva con ese email para esa fecha.");
        }

        nuevaReserva.setFechaCreacion(LocalDateTime.now());
        nuevaReserva.setEstado("pendiente");
        return ResponseEntity.ok(reservaRepository.save(nuevaReserva));
    }
}
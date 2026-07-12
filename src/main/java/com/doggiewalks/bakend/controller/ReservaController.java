package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Reserva;
import com.doggiewalks.bakend.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.doggiewalks.bakend.service.EmailService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EmailService emailService;

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

        // Verificamos si el paseador ya tiene una reserva en esa fecha y hora
        if (nuevaReserva.getIdPaseador() != null && nuevaReserva.getIdPaseador() != 0) {
            if (reservaRepository.existsByIdPaseadorAndFechaAndHora(
                    nuevaReserva.getIdPaseador(),
                    nuevaReserva.getFecha(),
                    nuevaReserva.getHora())) {
                return ResponseEntity
                        .status(423)
                        .body("El paseador seleccionado no está disponible en esa fecha y hora. Por favor elige otro horario.");
            }
        }

        // Si pasa todas las validaciones, guardamos la reserva
        nuevaReserva.setFechaCreacion(LocalDateTime.now());
        nuevaReserva.setEstado("pendiente");
        Reserva guardada = reservaRepository.save(nuevaReserva);

        emailService.enviar(
                guardada.getEmail(),
                "Tu reserva en Doggie Walks quedó registrada",
                "Hola " + guardada.getNombreCliente() + ",\n\n"
                        + "¡Recibimos tu reserva! Estos son los datos:\n\n"
                        + "Tipo de paseo: " + guardada.getTipoPaseo() + "\n"
                        + "Fecha: " + guardada.getFecha() + "\n"
                        + "Hora: " + guardada.getHora() + "\n\n"
                        + "Te contactaremos a la brevedad posible por via telefónica.\n\n"
                        + "Gracias por confiar en nosotros.\n"
                        + "El equipo de Doggie Walks"
        );

        return ResponseEntity.ok(guardada);
    }
}
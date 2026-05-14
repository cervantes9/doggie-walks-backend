package com.doggiewalks.bakend;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    private String email;

    private String telefono;

    @Column(name = "id_paseador")
    private Integer idPaseador;

    @Column(name = "tipo_paseo")
    private String tipoPaseo;

    private LocalDate fecha;

    private LocalTime hora;

    private String mensaje;

    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}
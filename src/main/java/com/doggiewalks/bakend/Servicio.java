package com.doggiewalks.bakend;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

// Entidad JPA mapeada a la tabla "servicios"
@Entity
@Table(name = "servicios")
@Data
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincremental
    private Integer id;

    private String titulo;
    private String descripcion;

    @Column(name = "duracion_minutos") // en la BD las columnas usan snake_case
    private Integer duracionMinutos;

    private BigDecimal precio;

    @Column(name = "imagen_url")
    private String imagenUrl;
}
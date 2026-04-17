package com.doggiewalks.bakend;

import jakarta.persistence.*; // trae las etiquetas magicas @Entity para acortar el codigo
import lombok.Data;
import java.math.BigDecimal;

@Entity                      // 1. Dice: "Esta clase es una tabla de la BD"
@Table(name = "servicios")   // 2. Dice: "La tabla se llama 'servicios'"
@Data                        // 3. Lombok: Crea getters, setters y toString solo
public class Servicio {

    @Id                      // 4. Clave Primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // esto es para que le asigne un id o numero automatico serial.
    private Integer id;

    private String titulo;
    private String descripcion;

    @Column(name = "duracion_minutos") // @Column traduce el nombre de la variable en esta caja para que coincida con el de la base de datos que está todo en minusculas.
    private Integer duracionMinutos;

    private BigDecimal precio;

    @Column(name = "imagen_url")
    private String imagenUrl;
}
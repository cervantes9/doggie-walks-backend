package com.doggiewalks.bakend;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name= "paseadores")
@Data

public class Paseador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String nombre;

    @Column(name = "experiencia_anos")
    private int experienciaAnos;

    @Column(name = "descripcion_perfil")
    private String descripcionPerfil;

    @Column(name = "foto_url")
    private String fotoUrl;

    private String certificaciones;




}

package com.doggiewalks.bakend;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "mensajes_contacto")
@Data

public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_cliente" )
    private String nombreCliente;

    private String email;

    private String telefono; // este lo coloqué como cadena porque cuando hacía las cajas en java con netbeans tuve problemas a la hora de obtener los datos desde
      // un formulario cuando habia que transformar los datos para luego mandarlos a la base de datos de tipo numero al tipo de dato que trabaja con sql creaba un conflicto pero no se si con este IDE no haya problemas.

    private String mensaje;

    @Column(name = "fecha_envio")
    private java.time.LocalDateTime fechaEnvio;

    private Boolean leido;

}

package com.doggiewalks.bakend.repository;

import com.doggiewalks.bakend.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le dice a Spring: "Este es mi trabajador de la base de datos"
public interface ServicioRepository extends JpaRepository<Servicio, Integer> { // Le indicas que el tipo de dato de la Llave Primaria (el @Id) de esa tabla es un número entero.

    // ¡ESTO ES TODO! Está vacío, pero ya tiene superpoderes.

    /*
       Al heredar (extends) de JpaRepository, Spring te regala automáticamente:
       - findAll()          -> Hace un SELECT * FROM servicios
       - findById(id)       -> Hace un SELECT * FROM servicios WHERE id = ?
       - save(servicio)     -> Hace un INSERT o un UPDATE automáticamente
       - deleteById(id)     -> Hace un DELETE FROM servicios WHERE id = ?
    */
}
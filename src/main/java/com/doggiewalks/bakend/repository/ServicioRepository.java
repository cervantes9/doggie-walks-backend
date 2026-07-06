package com.doggiewalks.bakend.repository;

import com.doggiewalks.bakend.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    // Hereda de JpaRepository los métodos CRUD estándar: findAll(), findById(), save(), deleteById()
}

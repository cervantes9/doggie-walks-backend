package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Servicio;
import com.doggiewalks.bakend.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*") // permite peticiones desde el frontend (CORS)
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    // Devuelve el listado de servicios
    @GetMapping
    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }
}
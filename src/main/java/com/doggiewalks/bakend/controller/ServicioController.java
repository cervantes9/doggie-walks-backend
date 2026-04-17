package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Servicio;
import com.doggiewalks.bakend.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. "Soy un mesero que sirve datos crudos (JSON), no páginas web (JSP)" //Controller
@RequestMapping("/api/servicios") // 2. "Atiendo en esta dirección URL" //@Path
@CrossOrigin(origins = "*") // 3. "Dejo entrar a cualquier página web que me pida datos (Angular)"
public class ServicioController {

    // 4. Llamamos al chef (El repositorio)
    @Autowired // En Web III: Usabas @Inject para traer a tu Repositorio.java gigante
    private ServicioRepository servicioRepository;

    // 5. Cuando alguien entre con el método GET a la URL de arriba, ejecuta esto:
    @GetMapping
    public List<Servicio> obtenerTodosLosServicios() {
        // Le pedimos al chef que busque todos los servicios en la BD y los devuelva
        return servicioRepository.findAll();
    }
}
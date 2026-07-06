package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Paseador;
import com.doggiewalks.bakend.repository.PaseadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paseadores")
@CrossOrigin(origins = "*") // permite peticiones desde el frontend (CORS)
public class PaseadorController {

    @Autowired
    private PaseadorRepository paseadorRepository;

    @GetMapping // Devuelve el listado de paseadores
    public List<Paseador> getPaseadores(){
        return paseadorRepository.findAll();
    }
}

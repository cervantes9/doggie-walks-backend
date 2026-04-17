package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Paseador;
import com.doggiewalks.bakend.repository.PaseadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller
@RequestMapping("/api/paseadores") //Path
@CrossOrigin(origins = "*") // Dejo entrar a cualquier página web que me pida datos (Angular)"
public class PaseadorController {

    @Autowired // esto es como Inject en MVC
    private PaseadorRepository paseadorRepository; // llamar repositorio Inject

    @GetMapping // // Cuando alguien entre con el método GET a la URL de arriba, ejecuta esto:
    public List<Paseador> getPaseadores(){
        return paseadorRepository.findAll();
    }
}

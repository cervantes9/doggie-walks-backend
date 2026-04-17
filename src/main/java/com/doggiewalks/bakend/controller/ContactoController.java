package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Contacto;
import com.doggiewalks.bakend.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //@Controller
@RequestMapping("/api/mensajes_contacto") //Path
@CrossOrigin(origins = "*") // Dejo entrar a cualquier página web que me pida datos (Angular)"
public class ContactoController {

    @Autowired // es como Inject en MVC
    private ContactoRepository contactoRepository;

    @GetMapping// Cuando alguien entre con el método GET a la URL de arriba, ejecuta esto:

    public List<Contacto> getContactos() {  // 1. Para LEER los mensajes (Para ti, el administrador)
        return contactoRepository.findAll();
    }

    @PostMapping // 2. Para CREAR un mensaje nuevo (Para el cliente en la web)
    public Contacto guardarMensaje(@RequestBody Contacto nuevoMensaje) { // @RequestBody: Es un traductor automático.
        // Le dice a Spring: "Oye, lee el texto JSON que viene en el cuerpo de la petición, mira mi clase Contacto,
        // y construye tú mismo la caja llenando las variables que coincidan".
        return contactoRepository.save(nuevoMensaje);
    }

}

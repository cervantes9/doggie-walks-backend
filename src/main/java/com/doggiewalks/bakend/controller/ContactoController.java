package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Contacto;
import com.doggiewalks.bakend.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/mensajes_contacto")
@CrossOrigin(origins = "*") // permite peticiones desde el frontend (CORS)
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping // Lista los mensajes recibidos (uso interno del administrador)
    public List<Contacto> getContactos() {
        return contactoRepository.findAll();
    }

    @PostMapping // Guarda un mensaje nuevo enviado desde el formulario de contacto
    public Contacto guardarMensaje(@RequestBody Contacto nuevoMensaje) {
        return contactoRepository.save(nuevoMensaje);
    }

}

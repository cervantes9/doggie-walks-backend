package com.doggiewalks.bakend.controller;

import com.doggiewalks.bakend.Contacto;
import com.doggiewalks.bakend.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.doggiewalks.bakend.service.EmailService;

import java.util.List;


@RestController
@RequestMapping("/api/mensajes_contacto")
@CrossOrigin(origins = "*") // permite peticiones desde el frontend (CORS)
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping // Lista los mensajes recibidos (uso interno del administrador)
    public List<Contacto> getContactos() {
        return contactoRepository.findAll();
    }

    @PostMapping // Guarda un mensaje nuevo enviado desde el formulario de contacto
    public Contacto guardarMensaje(@RequestBody Contacto nuevoMensaje) {
        Contacto guardado = contactoRepository.save(nuevoMensaje);

        emailService.enviar(
                guardado.getEmail(),
                "Recibimos tu consulta — Doggie Walks",
                "Hola " + guardado.getNombreCliente() + ",\n\n"
                        + "Recibimos tu mensaje y te responderemos a la brevedad.\n\n"
                        + "Tu consulta: \"" + guardado.getMensaje() + "\"\n\n"
                        + "Gracias por contactarnos.\n"
                        + "El equipo de Doggie Walks"
        );

        return guardado;
    }
}

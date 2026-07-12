package com.doggiewalks.bakend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String remitente;

    @Value("${BREVO_API_KEY:}")
    private String brevoApiKey;

    private final RestClient http = RestClient.create();

    // Envía el correo vía la API HTTPS de Brevo (Railway bloquea el SMTP saliente).
    public void enviar(String para, String asunto, String cuerpo) {
        try {
            http.post()
                    .uri("https://api.brevo.com/v3/smtp/email")
                    .header("api-key", brevoApiKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Map.of(
                            "sender", Map.of("name", "Doggie Walks", "email", remitente),
                            "to", List.of(Map.of("email", para)),
                            "subject", asunto,
                            "textContent", cuerpo))
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            System.err.println("No se pudo enviar el correo a " + para + ": " + e.getMessage());
        }
    }
}
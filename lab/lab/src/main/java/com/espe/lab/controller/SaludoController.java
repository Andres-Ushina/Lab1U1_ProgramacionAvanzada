
package com.espe.lab.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController {

    @Value("Aplicación Spring Boot en funcionamiento - ESPE")
    private String mensaje;

    @Value("default")
    private String perfil;

    @GetMapping("/saludo")
    public Map<String, String> obtenerSaludo() {
        Map<String, String> respuesta = new LinkedHashMap<>();
        respuesta.put("mensaje", mensaje);
        respuesta.put("perfil", perfil);
        return respuesta;
    }
}

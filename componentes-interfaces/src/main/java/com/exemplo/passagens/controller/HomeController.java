package com.exemplo.passagens.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "API de Passagens Aéreas funcionando! Acesse /passagens para listar as passagens.";
    }
}
package com.exemplo.passagens.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeControllerTest {

    @Test
    void deveRetornarMensagemInicialDaApi() {
        HomeController controller = new HomeController();

        String resposta = controller.home();

        assertEquals(
                "API de Passagens Aéreas funcionando! Acesse /passagens para listar as passagens.",
                resposta
        );
    }
}
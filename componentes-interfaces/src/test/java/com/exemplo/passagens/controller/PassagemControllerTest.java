package com.exemplo.passagens.controller;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import com.exemplo.passagens.service.PassagemService;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PassagemControllerTest {

    @Test
    void deveListarPassagens() {
        PassagemService passagemService = mock(PassagemService.class);

        List<PassagemAerea> passagens = Arrays.asList(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        when(passagemService.listarPassagensAereas()).thenReturn(passagens);

        PassagemController controller = new PassagemController(passagemService);

        List<PassagemAerea> resultado = controller.listarPassagens();

        assertEquals(1, resultado.size());
        assertEquals("Rio", resultado.get(0).getDestino());

        verify(passagemService, times(1)).listarPassagensAereas();
    }

    @Test
    void deveBuscarPassagemPorId() {
        PassagemService passagemService = mock(PassagemService.class);

        Passagem passagem = new PassagemAerea(
                1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        when(passagemService.obterPassagemPorId(1)).thenReturn(passagem);

        PassagemController controller = new PassagemController(passagemService);

        Passagem resultado = controller.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Rio", resultado.getDestino());

        verify(passagemService, times(1)).obterPassagemPorId(1);
    }

    @Test
    void deveFiltrarPassagens() {
        PassagemService passagemService = mock(PassagemService.class);

        Map<String, String> filtros = new HashMap<>();
        filtros.put("destino", "Rio");

        List<Passagem> passagensFiltradas = Arrays.asList(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        when(passagemService.filtrarPassagens(filtros)).thenReturn(passagensFiltradas);

        PassagemController controller = new PassagemController(passagemService);

        List<Passagem> resultado = controller.filtrarPassagens(filtros);

        assertEquals(1, resultado.size());
        assertEquals("Rio", resultado.get(0).getDestino());

        verify(passagemService, times(1)).filtrarPassagens(filtros);
    }

    @Test
    void deveAdicionarPassagem() {
        PassagemService passagemService = mock(PassagemService.class);

        PassagemAerea passagem = new PassagemAerea(
                1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        PassagemController controller = new PassagemController(passagemService);

        String resposta = controller.adicionarPassagem(passagem);

        assertEquals("Passagem adicionada com sucesso.", resposta);

        verify(passagemService, times(1)).adicionarPassagem(passagem);
    }
}
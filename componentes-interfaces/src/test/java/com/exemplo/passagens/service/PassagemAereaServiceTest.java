package com.exemplo.passagens.service;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PassagemAereaServiceTest {

    @Test
    void deveAdicionarEListarPassagens() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        List<PassagemAerea> passagens = service.listarPassagensAereas();

        assertEquals(1, passagens.size());
        assertEquals("São Paulo", passagens.get(0).getOrigem());
        assertEquals("Rio", passagens.get(0).getDestino());
        assertEquals("Latam", passagens.get(0).getCompanhia());
    }

    @Test
    void deveFiltrarPassagensPorDestino() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        service.adicionarPassagem(
                new PassagemAerea(2, "São Paulo", "Bahia", 700.0, "Econômica", 5, "Gol", new Date(), "B1")
        );

        Map<String, String> filtros = new HashMap<>();
        filtros.put("destino", "Rio");

        List<Passagem> resultado = service.filtrarPassagens(filtros);

        assertEquals(1, resultado.size());
        assertEquals("Rio", resultado.get(0).getDestino());
    }

    @Test
    void deveFiltrarPassagensPorCompanhia() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        service.adicionarPassagem(
                new PassagemAerea(2, "São Paulo", "Bahia", 700.0, "Econômica", 5, "Gol", new Date(), "B1")
        );

        Map<String, String> filtros = new HashMap<>();
        filtros.put("companhia", "Gol");

        List<Passagem> resultado = service.filtrarPassagens(filtros);

        assertEquals(1, resultado.size());
        assertEquals("Gol", resultado.get(0).getCompanhia());
    }

    @Test
    void deveRetornarListaVaziaQuandoFiltroNaoEncontrarResultado() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        Map<String, String> filtros = new HashMap<>();
        filtros.put("companhia", "Azul");

        List<Passagem> resultado = service.filtrarPassagens(filtros);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveBuscarPassagemPorIdExistente() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        Passagem passagem = service.obterPassagemPorId(1);

        assertNotNull(passagem);
        assertEquals(1, passagem.getId());
        assertEquals("Rio", passagem.getDestino());
    }

    @Test
    void deveRetornarNullQuandoIdNaoExistir() {
        PassagemAereaService service = new PassagemAereaService();

        service.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        Passagem passagem = service.obterPassagemPorId(999);

        assertNull(passagem);
    }
}
package com.exemplo.passagens.controller;

import com.exemplo.passagens.dto.AdicionarItemRequest;
import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import com.exemplo.passagens.service.CarrinhoService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarrinhoControllerTest {

    @Test
    void deveAdicionarItemAoCarrinho() {
        CarrinhoService carrinhoService = mock(CarrinhoService.class);

        AdicionarItemRequest request = new AdicionarItemRequest();
        request.setIdPassagem(1);
        request.setQtd(1);

        CarrinhoController controller = new CarrinhoController(carrinhoService);

        String resposta = controller.adicionarItem(1, request);

        assertEquals("Item adicionado ao carrinho com sucesso.", resposta);

        verify(carrinhoService, times(1)).adicionarItem(1, 1, 1);
    }

    @Test
    void deveListarItensDoCarrinho() {
        CarrinhoService carrinhoService = mock(CarrinhoService.class);

        List<Passagem> itens = Arrays.asList(
                new PassagemAerea(1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1")
        );

        when(carrinhoService.listarItens(1)).thenReturn(itens);

        CarrinhoController controller = new CarrinhoController(carrinhoService);

        List<Passagem> resultado = controller.listarItens(1);

        assertEquals(1, resultado.size());
        assertEquals("Rio", resultado.get(0).getDestino());

        verify(carrinhoService, times(1)).listarItens(1);
    }

    @Test
    void deveRemoverItemDoCarrinho() {
        CarrinhoService carrinhoService = mock(CarrinhoService.class);

        CarrinhoController controller = new CarrinhoController(carrinhoService);

        String resposta = controller.removerItem(1, 0);

        assertEquals("Item removido do carrinho com sucesso.", resposta);

        verify(carrinhoService, times(1)).removerItem(1, 0);
    }

    @Test
    void deveCalcularTotalDoCarrinho() {
        CarrinhoService carrinhoService = mock(CarrinhoService.class);

        when(carrinhoService.calcularTotal(1)).thenReturn(500.0);

        CarrinhoController controller = new CarrinhoController(carrinhoService);

        double total = controller.calcularTotal(1);

        assertEquals(500.0, total);

        verify(carrinhoService, times(1)).calcularTotal(1);
    }
}
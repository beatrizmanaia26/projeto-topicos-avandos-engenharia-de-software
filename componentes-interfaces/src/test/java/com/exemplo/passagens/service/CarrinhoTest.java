package com.exemplo.passagens.service;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarrinhoTest {

    @Test
    void deveAdicionarItemAoCarrinhoQuandoPassagemExistir() {
        PassagemService passagemService = mock(PassagemService.class);

        Passagem passagem = new PassagemAerea(
                1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        when(passagemService.obterPassagemPorId(1)).thenReturn(passagem);

        Carrinho carrinho = new Carrinho(passagemService);

        carrinho.adicionarItem(1, 1, 1);

        List<Passagem> itens = carrinho.listarItens(1);

        assertEquals(1, itens.size());
        assertEquals(1, itens.get(0).getId());
        assertEquals("Rio", itens.get(0).getDestino());

        verify(passagemService, times(1)).obterPassagemPorId(1);
    }

    @Test
    void deveAdicionarQuantidadeCorretaAoCarrinho() {
        PassagemService passagemService = mock(PassagemService.class);

        Passagem passagem = new PassagemAerea(
                2, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        when(passagemService.obterPassagemPorId(2)).thenReturn(passagem);

        Carrinho carrinho = new Carrinho(passagemService);

        carrinho.adicionarItem(1, 2, 3);

        List<Passagem> itens = carrinho.listarItens(1);

        assertEquals(3, itens.size());
        assertEquals(1500.0, carrinho.calcularTotal(1));
    }

    @Test
    void deveCalcularTotalDoCarrinho() {
        PassagemService passagemService = mock(PassagemService.class);

        Passagem passagem1 = new PassagemAerea(
                1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        Passagem passagem2 = new PassagemAerea(
                2, "São Paulo", "Bahia", 700.0, "Econômica", 5, "Gol", new Date(), "B1"
        );

        when(passagemService.obterPassagemPorId(1)).thenReturn(passagem1);
        when(passagemService.obterPassagemPorId(2)).thenReturn(passagem2);

        Carrinho carrinho = new Carrinho(passagemService);

        carrinho.adicionarItem(1, 1, 1);
        carrinho.adicionarItem(1, 2, 1);

        double total = carrinho.calcularTotal(1);

        assertEquals(1200.0, total);
    }

    @Test
    void deveRemoverItemDoCarrinho() {
        PassagemService passagemService = mock(PassagemService.class);

        Passagem passagem = new PassagemAerea(
                1, "São Paulo", "Rio", 500.0, "Econômica", 10, "Latam", new Date(), "A1"
        );

        when(passagemService.obterPassagemPorId(1)).thenReturn(passagem);

        Carrinho carrinho = new Carrinho(passagemService);

        carrinho.adicionarItem(1, 1, 2);

        carrinho.removerItem(1, 0);

        List<Passagem> itens = carrinho.listarItens(1);

        assertEquals(1, itens.size());
        assertEquals(500.0, carrinho.calcularTotal(1));
    }

    @Test
    void deveLancarErroQuandoPassagemNaoExistir() {
        PassagemService passagemService = mock(PassagemService.class);

        when(passagemService.obterPassagemPorId(999)).thenReturn(null);

        Carrinho carrinho = new Carrinho(passagemService);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> carrinho.adicionarItem(1, 999, 1)
        );

        assertEquals("Passagem não encontrada para o ID: 999", exception.getMessage());
    }

    @Test
    void deveLancarErroAoRemoverItemInexistente() {
        PassagemService passagemService = mock(PassagemService.class);

        Carrinho carrinho = new Carrinho(passagemService);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> carrinho.removerItem(1, 0)
        );

        assertEquals("Item não encontrado no carrinho.", exception.getMessage());
    }
}
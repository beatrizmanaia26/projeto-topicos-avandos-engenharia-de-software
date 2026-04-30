package com.exemplo.passagens.controller;

import com.exemplo.passagens.dto.AdicionarItemRequest;
import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/{idUsuario}/itens")
    public String adicionarItem(@PathVariable int idUsuario,
                                @RequestBody AdicionarItemRequest request) {

        carrinhoService.adicionarItem(
                idUsuario,
                request.getIdPassagem(),
                request.getQtd()
        );

        return "Item adicionado ao carrinho com sucesso.";
    }

    @GetMapping("/{idUsuario}/itens")
    public List<Passagem> listarItens(@PathVariable int idUsuario) {
        return carrinhoService.listarItens(idUsuario);
    }

    @DeleteMapping("/{idUsuario}/itens/{idItem}")
    public String removerItem(@PathVariable int idUsuario,
                              @PathVariable int idItem) {

        carrinhoService.removerItem(idUsuario, idItem);

        return "Item removido do carrinho com sucesso.";
    }

    @GetMapping("/{idUsuario}/total")
    public double calcularTotal(@PathVariable int idUsuario) {
        return carrinhoService.calcularTotal(idUsuario);
    }
}
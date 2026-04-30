package com.exemplo.passagens.controller;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import com.exemplo.passagens.service.PassagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/passagens")
public class PassagemController {

    private final PassagemService passagemService;

    public PassagemController(PassagemService passagemService) {
        this.passagemService = passagemService;
    }

    @GetMapping
    public List<PassagemAerea> listarPassagens() {
        return passagemService.listarPassagensAereas();
    }

    @GetMapping("/{id}")
    public Passagem buscarPorId(@PathVariable int id) {
        return passagemService.obterPassagemPorId(id);
    }

    @GetMapping("/filtrar")
    public List<Passagem> filtrarPassagens(@RequestParam Map<String, String> filtros) {
        return passagemService.filtrarPassagens(filtros);
    }

    @PostMapping
    public String adicionarPassagem(@RequestBody PassagemAerea passagem) {
        passagemService.adicionarPassagem(passagem);
        return "Passagem adicionada com sucesso.";
    }
}
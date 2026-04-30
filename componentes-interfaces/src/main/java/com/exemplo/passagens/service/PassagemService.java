package com.exemplo.passagens.service;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;

import java.util.List;
import java.util.Map;

public interface PassagemService {

    void adicionarPassagem(PassagemAerea p);

    List<PassagemAerea> listarPassagensAereas();

    List<Passagem> filtrarPassagens(Map<String, String> filtros);

    Passagem obterPassagemPorId(int idPassagem);
}
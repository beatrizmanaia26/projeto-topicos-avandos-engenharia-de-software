
package com.exemplo.passagens.service;

import com.exemplo.passagens.model.Passagem;

import java.util.List;

public interface CarrinhoService {

    void adicionarItem(int idUsuario, int idPassagem, int qtd);

    List<Passagem> listarItens(int idUsuario);

    void removerItem(int idUsuario, int idItem);

    double calcularTotal(int idUsuario);
}
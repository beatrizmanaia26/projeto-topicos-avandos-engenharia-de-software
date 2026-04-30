package com.exemplo.passagens.dto;

public class AdicionarItemRequest {

    private int idPassagem;
    private int qtd;

    public AdicionarItemRequest() {
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
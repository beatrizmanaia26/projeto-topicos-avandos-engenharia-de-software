
package com.exemplo.passagens.model;

import java.util.Date;

public class PassagemAerea extends Passagem {

    public PassagemAerea() {
        super();
    }

    public PassagemAerea(int id, String origem, String destino, double preco, String classe,
                         int qtd, String companhia, Date data, String assento) {
        super(id, origem, destino, preco, classe, qtd, companhia, data, assento);
    }
}
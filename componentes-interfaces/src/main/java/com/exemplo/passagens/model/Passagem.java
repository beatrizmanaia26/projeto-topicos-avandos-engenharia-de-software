// import java.util.Date;

// //preferencias da passagem 

// public class Passagem {
//     protected int id;
//     protected String origem;
//     protected String destino;
//     protected double preco;
//     protected String classe;
//     protected int qtd;
//     protected String companhia;
//     protected Date data;
//     protected String assento;

//     public Passagem(int id, String origem, String destino, double preco, String classe, int qtd, String companhia, Date data, String assento) {
//         this.id = id;
//         this.origem = origem;
//         this.destino = destino;
//         this.preco = preco;
//         this.classe = classe;
//         this.qtd = qtd;
//         this.companhia = companhia;
//         this.data = data;
//         this.assento = assento;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getOrigem() {
//         return origem;
//     }

//     public String getDestino() {
//         return destino;
//     }

//     public double getPreco() {
//         return preco;
//     }

//     public String getClasse() {
//         return classe;
//     }

//     public int getQtd() {
//         return qtd;
//     }

//     public String getCompanhia() {
//         return companhia;
//     }

//     public Date getData() {
//         return data;
//     }

//     public String getAssento() {
//         return assento;
//     }
// }

package com.exemplo.passagens.model;

import java.util.Date;

public class Passagem {

    private int id;
    private String origem;
    private String destino;
    private double preco;
    private String classe;
    private int qtd;
    private String companhia;
    private Date data;
    private String assento;

    public Passagem() {
    }

    public Passagem(int id, String origem, String destino, double preco, String classe,
                    int qtd, String companhia, Date data, String assento) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
        this.classe = classe;
        this.qtd = qtd;
        this.companhia = companhia;
        this.data = data;
        this.assento = assento;
    }

    public int getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }

    public String getClasse() {
        return classe;
    }

    public int getQtd() {
        return qtd;
    }

    public String getCompanhia() {
        return companhia;
    }

    public Date getData() {
        return data;
    }

    public String getAssento() {
        return assento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }
}
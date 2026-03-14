public class Passagem {
    protected int id;
    protected String origem;
    protected String destino;
    protected double preco;

    public Passagem(int id, String origem, String destino, double preco) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
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
}
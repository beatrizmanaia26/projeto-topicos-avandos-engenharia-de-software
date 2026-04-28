import java.util.Date;

//preferencias da passagem 

public class Passagem {
    protected int id;
    protected String origem;
    protected String destino;
    protected double preco;
    protected String classe;
    protected int qtd;
    protected String companhia;
    protected Date data;
    protected String assento;

    public Passagem(int id, String origem, String destino, double preco, String classe, int qtd, String companhia, Date data, String assento) {
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
}
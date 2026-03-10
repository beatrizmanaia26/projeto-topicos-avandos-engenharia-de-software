public class PassagemAerea extends Passagem {
    public String classeVoo;
    public String aeroportoEmbarque;

    public PassagemAerea(int id, String origem, String destino, double preco, String classeVoo, String aeroportoEmbarque) {
        super(id, origem, destino, preco);
        this.classeVoo = classeVoo;
        this.aeroportoEmbarque = aeroportoEmbarque;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements ICarrinho {
    public List<Passagem> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    @Override
    public void adicionarItem(Passagem passagem) {
        itens.add(passagem);
    }

    @Override
    public List<Passagem> listarItens() {
        return itens;
    }

    @Override
    public void removerItem(int idPassagem) {
        itens.removeIf(p -> p.id == idPassagem);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Passagem p : itens) {
            total += p.preco;
        }
        return total;
    }
}
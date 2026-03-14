import java.util.*;

public class Carrinho implements CarrinhoService {

    private PassagemService passagemService;

    private Map<Integer, List<Passagem>> carrinhos = new HashMap<>();

    public Carrinho(PassagemService passagemService) {
        this.passagemService = passagemService;
    }

    @Override
    public void adicionarItem(int idUsuario, int idPassagem, int qtd) {

        Passagem passagem = passagemService.obterPassagemPorId(idPassagem);

        if (passagem == null) return;

        carrinhos.putIfAbsent(idUsuario, new ArrayList<>());

        List<Passagem> itens = carrinhos.get(idUsuario);

        for (int i = 0; i < qtd; i++) {
            itens.add(passagem);
        }
    }

    @Override
    public List<Passagem> listarItens(int idUsuario) {

        return carrinhos.getOrDefault(idUsuario, new ArrayList<>());
    }

    @Override
    public void removerItem(int idUsuario, int idItem) {

        List<Passagem> itens = carrinhos.get(idUsuario);

        if (itens != null && idItem < itens.size()) {
            itens.remove(idItem);
        }
    }

    @Override
    public double calcularTotal(int idUsuario) {

        List<Passagem> itens = carrinhos.get(idUsuario);

        if (itens == null) return 0;

        double total = 0;

        for (Passagem p : itens) {
            total += p.getPreco();
        }

        return total;
    }
}
// CarrinhoService
// - AdicionarItem(idUsuario, idPassagem, qtd)
// - ListarItens(idUsuario)
// - RemoverItem(idUsuario, idItem)
// - CalcularTotal(idUsuario)

import java.util.List;

public interface ICarrinho {
    void adicionarItem(Passagem passagem);
    List<Passagem> listarItens();
    void removerItem(int idPassagem);
    double calcularTotal();
}
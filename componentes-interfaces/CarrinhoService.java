// CarrinhoService
// - AdicionarItem(idUsuario, idPassagem, qtd)
// - ListarItens(idUsuario)
// - RemoverItem(idUsuario, idItem)
// - CalcularTotal(idUsuario)

import java.util.List;

public interface CarrinhoService {
    void adicionarItem(int idUsuario, int idPassagem, int qtd);
    List<Passagem> listarItens(int idUsuario);
    void removerItem(int idUsuario, int idItem);
    double calcularTotal(int idUsuario);
}
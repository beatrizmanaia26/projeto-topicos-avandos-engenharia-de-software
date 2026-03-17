import java.util.*;

public class Main {

    public static void main(String[] args) {

        PassagemAerea passagemService = new PassagemAerea();

        Date hoje = new Date();

        // adicionando passagens de teste
        passagemService.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje)
        );

        passagemService.adicionarPassagem(
                new PassagemAerea(2, "São Paulo", "Salvador", 900, "Executiva", 5, "Gol", hoje)
        );

        passagemService.adicionarPassagem(
                new PassagemAerea(3, "Rio", "Recife", 800, "Econômica", 8, "Azul", hoje)
        );

        passagemService.adicionarPassagem(
                new PassagemAerea(4, "São Paulo", "Rio", 450, "Econômica", 12, "Gol", hoje)
        );

        // criação do carrinho com injeção de dependência
        CarrinhoService carrinho = new Carrinho(passagemService);
        int idUsuario = 1;

        // Listar todas as passagens
        System.out.println("\nPASSAGENS AÉREAS DISPONÍVEIS");
        for (PassagemAerea p : passagemService.listarPassagensAereas()) {
            System.out.println(
                    "ID: " + p.getId() +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Preço: " + p.getPreco() +
                    " | Classe: " + p.getClasse() +
                    " | Companhia: " + p.getCompanhia() +
                    " | Quantidade: " + p.getQtd()
            );
        }

        // FILTRO POR DESTINO
        System.out.println("\nFILTRAR PASSAGENS (Destino = Rio)");
        Map<String, String> filtros = new HashMap<>();
        filtros.put("destino", "Rio");
        List<Passagem> filtradas = passagemService.filtrarPassagens(filtros);

        for (Passagem p : filtradas) {
            System.out.println(
                    "ID: " + p.getId() +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Preço: " + p.getPreco()
            );
        }

        // FILTRO POR COMPANHIA
        System.out.println("\nFILTRAR PASSAGENS (Companhia = Gol)");
        filtros.clear();
        filtros.put("companhia", "Gol");
        filtradas = passagemService.filtrarPassagens(filtros);

        for (Passagem p : filtradas) {
            System.out.println(
                    "ID: " + p.getId() +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Companhia: " + p.getCompanhia() +
                    " | Preço: " + p.getPreco()
            );
        }

        // FILTRO POR CLASSE
        System.out.println("\nFILTRAR PASSAGENS (Classe = Econômica)");
        filtros.clear();
        filtros.put("classe", "Econômica");
        filtradas = passagemService.filtrarPassagens(filtros);

        for (Passagem p : filtradas) {
            System.out.println(
                    "ID: " + p.getId() +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Classe: " + p.getClasse()
            );
        }

        // FILTRO COMBINADO
        System.out.println("\nFILTRAR PASSAGENS (Origem = São Paulo + Destino = Rio)");
        filtros.clear();
        filtros.put("origem", "São Paulo");
        filtros.put("destino", "Rio");
        filtradas = passagemService.filtrarPassagens(filtros);

        for (Passagem p : filtradas) {
            System.out.println(
                    "ID: " + p.getId() +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Preço: " + p.getPreco()
            );
        }

        // TESTAR CARRINHO
        System.out.println("\nADICIONANDO PASSAGENS AO CARRINHO");
        carrinho.adicionarItem(idUsuario, 1, 1);
        carrinho.adicionarItem(idUsuario, 2, 2);

        // Listar carrinho
        System.out.println("\nITENS NO CARRINHO");
        List<Passagem> itensCarrinho = carrinho.listarItens(idUsuario);

        for (int i = 0; i < itensCarrinho.size(); i++) {
            Passagem p = itensCarrinho.get(i);
            System.out.println(
                    "Item " + i +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Preço: " + p.getPreco()
            );
        }

        // Calcular total
        double total = carrinho.calcularTotal(idUsuario);
        System.out.println("\nTOTAL DO CARRINHO: " + total);

        // Remover item
        System.out.println("\nREMOVENDO ITEM 0 DO CARRINHO");
        carrinho.removerItem(idUsuario, 0);
        System.out.println("\nCARRINHO ATUALIZADO");
        itensCarrinho = carrinho.listarItens(idUsuario);

        for (int i = 0; i < itensCarrinho.size(); i++) {
            Passagem p = itensCarrinho.get(i);
            System.out.println(
                    "Item " + i +
                    " | " + p.getOrigem() +
                    " -> " + p.getDestino() +
                    " | Preço: " + p.getPreco()
            );
        }
        System.out.println("\nTOTAL ATUALIZADO: " + carrinho.calcularTotal(idUsuario));
    }
}
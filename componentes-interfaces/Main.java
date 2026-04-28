import java.util.*;
import com.google.gson.Gson; 

public class Main {

    public static void main(String[] args) {

        PassagemAerea passagemService = new PassagemAerea();

        Date hoje = new Date();

        // adicionando passagens de teste
        passagemService.adicionarPassagem(
                new PassagemAerea(1, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje,"A1")
        );

        passagemService.adicionarPassagem(
               new PassagemAerea(2, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1")
        );

        passagemService.adicionarPassagem(
               new PassagemAerea(3, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje,"A1")
        );

        passagemService.adicionarPassagem(
                new PassagemAerea(4, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1")
        );

        // criação do carrinho 
        CarrinhoService carrinho = new Carrinho(passagemService); //carrinho depende de passagem e consulta passagens (orquestracao)
        int idUsuario = 1;

        // Listar todas as passagens
        
        Gson gson = new Gson();

        System.out.println("\nPASSAGENS EM JSON:");
        String json = gson.toJson(passagemService.listarPassagensAereas());
        System.out.println(json);

        //FILTRO POR DESTINO
        System.out.println("\nFILTRAR PASSAGENS (Destino = Rio)");
        Map<String, String> filtros = new HashMap<>();
        filtros.put("destino", "Rio");
        List<Passagem> filtradas = passagemService.filtrarPassagens(filtros);

        System.out.println("\nFILTRAR PASSAGENS (Destino = Rio) - JSON:");
        System.out.println(gson.toJson(filtradas));

        //FILTRO POR COMPANHIA
        System.out.println("\nFILTRAR PASSAGENS (Companhia = Gol)");
        filtros.clear();
        filtros.put("companhia", "Gol");
        filtradas = passagemService.filtrarPassagens(filtros);

        System.out.println("\nFILTRAR PASSAGENS (Companhia = Gol) - JSON:");
        System.out.println(gson.toJson(filtradas));

        //FILTRO POR CLASSE
        System.out.println("\nFILTRAR PASSAGENS (Classe = Econômica) - JSON");

        filtros.clear();
        filtros.put("classe", "Econômica");

        filtradas = passagemService.filtrarPassagens(filtros);

        System.out.println(gson.toJson(filtradas));

        //FILTRO COMBINADO
       System.out.println("\nFILTRAR PASSAGENS (Origem = São Paulo + Destino = Rio) - JSON");

        filtros.clear();
        filtros.put("origem", "São Paulo");
        filtros.put("destino", "Rio");

        filtradas = passagemService.filtrarPassagens(filtros);

        System.out.println(gson.toJson(filtradas));

        // CARRINHO
        System.out.println("\nADICIONANDO PASSAGENS AO CARRINHO");
        carrinho.adicionarItem(idUsuario, 1, 1); //Carrinho faz uma requisição para o serviço de passagens:
        carrinho.adicionarItem(idUsuario, 2, 2);

        // Listar carrinho
        System.out.println("\nITENS NO CARRINHO - JSON");

        List<Passagem> itensCarrinho = carrinho.listarItens(idUsuario);

        System.out.println(gson.toJson(itensCarrinho));

        // Calcular total
        double total = carrinho.calcularTotal(idUsuario);
        System.out.println("\nTOTAL DO CARRINHO: " + total);

        // Remover passagem
        System.out.println("\nREMOVENDO ITEM 0 DO CARRINHO");
        carrinho.removerItem(idUsuario, 0);
        System.out.println("\nCARRINHO ATUALIZADO");
        itensCarrinho = carrinho.listarItens(idUsuario);

       System.out.println("\nCARRINHO ATUALIZADO - JSON");

        itensCarrinho = carrinho.listarItens(idUsuario);

        System.out.println(gson.toJson(itensCarrinho));
        System.out.println("\nTOTAL ATUALIZADO: " + carrinho.calcularTotal(idUsuario));
    }
}
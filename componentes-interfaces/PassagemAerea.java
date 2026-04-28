import java.util.*;
import java.util.Date;

public class PassagemAerea extends Passagem implements PassagemService {

    private List<PassagemAerea> passagens = new ArrayList<>();

    public PassagemAerea(int id, String origem, String destino, double preco, String classe, int qtd, String companhia, Date data, String assento) {
        super(id, origem, destino, preco, classe, qtd, companhia, data, assento);
    }

    public PassagemAerea() {
        super(0, "", "", 0, "", 1, "", new Date(), "A1");
    }
    public void adicionarPassagem(PassagemAerea p) {
        passagens.add(p);
    }

    @Override
    public List<PassagemAerea> listarPassagensAereas() {
        return passagens;
    }

    @Override
    public List<Passagem> filtrarPassagens(Map<String, String> filtros) {

        List<Passagem> resultado = new ArrayList<>();

        for (PassagemAerea p : passagens) {

            boolean match = true;

            if (filtros.containsKey("id") &&
                p.getId() != Integer.parseInt(filtros.get("id"))) {
                match = false;
            }

            if (filtros.containsKey("origem") &&
                !p.getOrigem().equalsIgnoreCase(filtros.get("origem"))) {
                match = false;
            }

            if (filtros.containsKey("destino") &&
                !p.getDestino().equalsIgnoreCase(filtros.get("destino"))) {
                match = false;
            }

            if (filtros.containsKey("preco") &&
                p.getPreco() != Double.parseDouble(filtros.get("preco"))) {
                match = false;
            }

            if (filtros.containsKey("classe") &&
                !p.getClasse().equalsIgnoreCase(filtros.get("classe"))) {
                match = false;
            }

            if (filtros.containsKey("qtd") &&
                p.getQtd() != Integer.parseInt(filtros.get("qtd"))) {
                match = false;
            }

            if (filtros.containsKey("companhia") &&
                !p.getCompanhia().equalsIgnoreCase(filtros.get("companhia"))) {
                match = false;
            }

            if (match) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    @Override
    public Passagem obterPassagemPorId(int idPassagem) {

        for (PassagemAerea p : passagens) {
            if (p.getId() == idPassagem) {
                return p;
            }
        }

        return null;
    }
}
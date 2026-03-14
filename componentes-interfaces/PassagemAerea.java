import java.util.*;

public class PassagemAerea extends Passagem implements PassagemService {

    private List<PassagemAerea> passagens = new ArrayList<>();

    public PassagemAerea(int id, String origem, String destino, double preco) {
        super(id, origem, destino, preco);
    }

    public PassagemAerea() {
        super(0, "", "", 0);
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

            if (filtros.containsKey("origem") &&
               !p.getOrigem().equalsIgnoreCase(filtros.get("origem"))) {
                match = false;
            }

            if (filtros.containsKey("destino") &&
               !p.getDestino().equalsIgnoreCase(filtros.get("destino"))) {
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
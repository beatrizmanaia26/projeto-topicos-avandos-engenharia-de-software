import java.util.List;
import java.util.Map;

public interface IPassagemService {
    List<PassagemAerea> listarPassagensAereas();
    List<Passagem> filtrarPassagens(Map<String, String> filtros);
    Passagem obterPassagemPorId(int idPassagem);
}
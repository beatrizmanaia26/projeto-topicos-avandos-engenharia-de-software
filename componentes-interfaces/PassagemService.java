/*
PassagemService
- ListarPassagensAereas()
- ListarPassagensMaritimas()
- FiltrarPassagens(filtros)
- ObterPassagemPorId(idPassagem)
*/

import java.util.List;
import java.util.Map;

public interface PassagemService {
    List<PassagemAerea> listarPassagensAereas();
    List<Passagem> filtrarPassagens(Map<String, String> filtros);
    Passagem obterPassagemPorId(int idPassagem);
}
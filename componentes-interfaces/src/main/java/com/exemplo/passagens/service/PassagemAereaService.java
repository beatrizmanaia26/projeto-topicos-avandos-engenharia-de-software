package com.exemplo.passagens.service;

import com.exemplo.passagens.model.Passagem;
import com.exemplo.passagens.model.PassagemAerea;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class PassagemAereaService implements PassagemService {

    private final List<PassagemAerea> passagens = new ArrayList<>();

    @PostConstruct
    public void carregarDadosIniciais() {
        Date hoje = new Date();

        adicionarPassagem(new PassagemAerea(1, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1"));
        adicionarPassagem(new PassagemAerea(2, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1"));
        adicionarPassagem(new PassagemAerea(3, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1"));
        adicionarPassagem(new PassagemAerea(4, "São Paulo", "Rio", 500, "Econômica", 10, "Latam", hoje, "A1"));
    }

    @Override
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
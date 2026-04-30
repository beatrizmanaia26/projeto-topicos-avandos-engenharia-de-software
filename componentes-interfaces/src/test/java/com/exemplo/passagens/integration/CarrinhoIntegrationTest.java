//O objetivo do teste de integração no seu cenário é validar a comunicação entre os dois serviços:
//CarrinhoService (orquestrador) chama PassagemService.
//Essa é a única integração entre serviços existente no código. Logo, soó preciso testar carrinhomvn -Dtest=CarrinhoIntegrationTest test

package com.exemplo.passagens.integration;

import com.exemplo.passagens.dto.AdicionarItemRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarrinhoIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveAdicionarItemAoCarrinhoComSucesso() {
        // 1. Verificar que existe uma passagem com ID 1 (criada pelo @PostConstruct)
        ResponseEntity<String> getPassagens = restTemplate.getForEntity("/passagens", String.class);
        assertThat(getPassagens.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getPassagens.getBody()).contains("\"id\":1");

        // 2. Adicionar item ao carrinho
        AdicionarItemRequest request = new AdicionarItemRequest();
        request.setIdPassagem(1);
        request.setQtd(2);

        HttpEntity<AdicionarItemRequest> entity = new HttpEntity<>(request);
        ResponseEntity<String> postResponse = restTemplate.exchange(
                "/carrinho/1/itens",
                HttpMethod.POST,
                entity,
                String.class
        );
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody()).contains("adicionado ao carrinho");

        // 3. Verificar itens no carrinho
        ResponseEntity<String> itensResponse = restTemplate.getForEntity("/carrinho/1/itens", String.class);
        assertThat(itensResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(itensResponse.getBody()).contains("Rio"); // destino da passagem ID 1

        // 4. Calcular total (cada passagem custa 500, 2 unidades = 1000)
        ResponseEntity<Double> totalResponse = restTemplate.getForEntity("/carrinho/1/total", Double.class);
        assertThat(totalResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(totalResponse.getBody()).isEqualTo(1000.0);
    }

    @Test
    void deveRetornarErroAoAdicionarPassagemInexistente() {
        AdicionarItemRequest request = new AdicionarItemRequest();
        request.setIdPassagem(999); // ID que não existe
        request.setQtd(1);

        HttpEntity<AdicionarItemRequest> entity = new HttpEntity<>(request);
        ResponseEntity<String> response = restTemplate.exchange(
                "/carrinho/1/itens",
                HttpMethod.POST,
                entity,
                String.class
        );
        // O CarrinhoService lança IllegalArgumentException que é tratada como erro 500
        // Se você tiver um @ControllerAdvice, pode retornar 400/404. Ajuste conforme seu código.
        assertThat(response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()).isTrue();
    }
}
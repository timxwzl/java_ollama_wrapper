package com.example.demo.service;

import com.example.demo.model.OllamaRequest;
import com.example.demo.model.OllamaResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class OllamaService {

    private final WebClient ollamaWebClient;

    @Value("${ollama.model}")
    private String defaultModel;

    public OllamaService(WebClient ollamaWebClient) {
        this.ollamaWebClient = ollamaWebClient;
    }

    public Flux<OllamaResponse> generateResponse(String prompt) {
        OllamaRequest request = new OllamaRequest();
        request.setPrompt(prompt);
        request.setModel(defaultModel);

        return ollamaWebClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(OllamaResponse.class);
    }

    public int add(int x, int y) {
        return 0;
    }
}

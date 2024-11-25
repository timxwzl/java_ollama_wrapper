package com.example.demo.controller;

import com.example.demo.model.OllamaResponse;
import com.example.demo.service.OllamaService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ollama")
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping(value = "/generate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<OllamaResponse> generateStream(@RequestBody String prompt) {
        return ollamaService.generateResponse(prompt);
    }

    @GetMapping("/health")
    public String health() {
        return "Service is running";
    }
}

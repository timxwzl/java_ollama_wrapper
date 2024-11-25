package com.example.demo.model;

import lombok.Data;

@Data
public class OllamaResponse {
    private String model;
    private String response;
    private boolean done;
}

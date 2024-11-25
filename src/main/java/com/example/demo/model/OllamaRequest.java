package com.example.demo.model;

import lombok.Data;

@Data
public class OllamaRequest {
    private String prompt;
    private String model;
    private boolean stream = true;
}

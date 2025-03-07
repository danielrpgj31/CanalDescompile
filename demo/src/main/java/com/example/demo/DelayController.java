package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DelayController {

    public static void main(String[] args) {
        SpringApplication.run(DelayController.class, args);
    }

    // Lista estática para armazenar objetos grandes
    private static List<byte[]> memoria = new ArrayList<>();

    @GetMapping("/simulate-delay")
    public ResponseEntity<String> simulateDelay() {
        try {
            // Cria um objeto grande e adiciona à lista
            byte[] objetoGrande = new byte[128 * 1024 * 1]; // 128KB
            memoria.add(objetoGrande);

            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
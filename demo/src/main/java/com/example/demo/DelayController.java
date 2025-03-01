package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DelayController {

    public static void main(String[] args) {
        SpringApplication.run(DelayController.class, args);
    }

    @GetMapping("/simulate-delay")
    public ResponseEntity<String> simulateDelay() {
        try {
            // Cria um objeto grande que não será coletado pelo GC
            byte[] memoria = new byte[1024 * 1024 * 10]; // 100MB

            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}

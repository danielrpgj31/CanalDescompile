package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DelayController {

    public static void main(String[] args) {
        SpringApplication.run(DelayController.class, args);
    }

    @GetMapping("/simulate-delay")
    public String simulateDelay() throws InterruptedException {
        // Simula um delay de 10 segundos
        Thread.sleep(10000);
        return "Resposta após 10 segundos!";
    }
}

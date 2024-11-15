package com.devsuperior.dslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Anotação que indica que esta é uma classe de configuração principal para uma aplicação Spring Boot.
// Combina as anotações @Configuration, @EnableAutoConfiguration e @ComponentScan, permitindo a configuração
// automática do Spring Boot.
public class DslistApplication {

    public static void main(String[] args) {
        // Método principal que inicia a aplicação.
        SpringApplication.run(DslistApplication.class, args);
        // Método estático que inicializa o contexto da aplicação Spring e inicia a aplicação Spring Boot.
    }

}
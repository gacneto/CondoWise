package com.condominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SistemaEncomendasApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SistemaEncomendasApplication.class, args);
        MenuPrincipal menu = context.getBean(MenuPrincipal.class);
        menu.iniciar();
    }
}
package com.example.Quiz;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Tutaj definiujesz ścieżkę do twojego API
                .allowedOrigins("http://localhost:1234") // Pozwól na dostęp z tej lokalizacji
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Ustaw dozwolone metody HTTP
    }
}
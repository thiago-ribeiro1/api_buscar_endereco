package com.accenture.consumo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite CORS em todos os endpoints
                        .allowedOrigins("http://localhost", "null") // Permite origens específicas
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite métodos HTTP
                        .allowedHeaders("*") // Permite todos os cabeçalhos
                        .allowCredentials(false); // Para credenciais, altere para true
            }
        };
    }
}

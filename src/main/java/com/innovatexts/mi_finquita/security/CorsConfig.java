/*package com.innovatexts.mi_finquita.security;

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
                registry.addMapping("/api/**") // Aplica a todas las rutas de la API
                        .allowedOrigins("http://localhost:3000") // Permite llamadas desde React
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                        .allowCredentials(true);
            }
        };
    }
}*/

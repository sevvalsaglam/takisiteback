package com.takisite.backend.config;

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
                registry.addMapping("/**") // tüm endpoint'ler
                        .allowedOrigins("*") // frontend buradan istek atabilir
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // izin verilen HTTP methodları
                        .allowedHeaders("*"); // tüm başlıklara izin ver
            }
        };
    }
}

package com.takisite.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm API endpoint'leri için
                .allowedOrigins(
                        "http://localhost:5173",
                        "https://takisite-sevval-saglam.vercel.app"
                )  // Hem local geliştirme hem Vercel için izin ver
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // İzin verilen HTTP metodları
                .allowedHeaders("*")  // Tüm headerlara izin ver
                .allowCredentials(true);  // Çerez veya token gibi bilgiler için
    }
}

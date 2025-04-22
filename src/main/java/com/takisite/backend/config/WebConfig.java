package com.takisite.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm API endpoint'leri için
                .allowedOrigins("http://localhost:5175")  // Frontend'in çalıştığı adres
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metotları
                .allowedHeaders("*")  // İzin verilen başlıklar
                .allowCredentials(true);  // Kimlik doğrulama gereksinimi varsa
    }
}

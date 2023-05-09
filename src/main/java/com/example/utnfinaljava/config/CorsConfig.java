package com.example.utnfinaljava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/auth/**")
                .allowedOrigins("http://localhost:4200", "https://davem22githubio-production.up.railway.app")
                .allowedMethods("*")
                .exposedHeaders("*");

                registry.addMapping("/api/**")
                .exposedHeaders("*")
                .allowedOrigins("htttps://davem22githubio-production.up.railway.app","http://localhost:4200")
                .allowedMethods("*");
            }
        };
    }
}

package com.example.finalfinalback3.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//Знаю, что так делать нельзя, но для пет-проекта, который дописывается впопыхах - необходимо
@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
//                        .allowedMethods()
//                        .allowedOrigins("*")
//                        .allowedHeaders("*")
//                        .maxAge(36000);
            }
        };
    }
}

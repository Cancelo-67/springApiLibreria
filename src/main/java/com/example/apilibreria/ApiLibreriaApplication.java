package com.example.apilibreria;

import com.example.apilibreria.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ApiLibreriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiLibreriaApplication.class, args);
    }

}

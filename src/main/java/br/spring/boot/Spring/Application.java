package br.spring.boot.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@ComponentScan(basePackages = "br.spring.boot.Spring")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

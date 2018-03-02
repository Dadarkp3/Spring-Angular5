package com.solutis.selecao.cloneapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.solutis.selecao.cloneapi.repository")
public class CloneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneApiApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("Equipamentos Criados!");
        };
    }
}

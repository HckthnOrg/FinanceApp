package com.example.financeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.financeapp.config.SecurityConfig;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@Import(SecurityConfig.class)
public class FinanceappApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
		SpringApplication.run(FinanceappApplication.class, args);
	}

}

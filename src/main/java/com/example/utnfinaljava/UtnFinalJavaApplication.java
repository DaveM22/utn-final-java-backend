package com.example.utnfinaljava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableWebSecurity
@EnableMethodSecurity(
    prePostEnabled = false, securedEnabled = false, jsr250Enabled = true
)
public class UtnFinalJavaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UtnFinalJavaApplication.class, args);
	}
}

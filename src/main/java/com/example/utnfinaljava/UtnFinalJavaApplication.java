package com.example.utnfinaljava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UtnFinalJavaApplication {

	public static void main(String[] args) {
		System.out.println("pass: " + new BCryptPasswordEncoder().encode("1234"));
		SpringApplication.run(UtnFinalJavaApplication.class, args);
		
	}

}

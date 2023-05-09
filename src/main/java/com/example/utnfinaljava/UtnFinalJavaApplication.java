package com.example.utnfinaljava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootApplication
@EnableTransactionManagement
@Controller
public class UtnFinalJavaApplication implements ErrorController {

	private static final String PATH = "/error";
	public static void main(String[] args) {
		SpringApplication.run(UtnFinalJavaApplication.class, args);
		


	}

	@RequestMapping(value = PATH)
    public String error() {
        return "forward:/index.html";
    }

    public String getErrorPath() {
        return PATH;
    }
}

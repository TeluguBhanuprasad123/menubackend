package com.codelibary.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.codelibary.www")
public class CodeLibaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeLibaryApplication.class, args);
		System.out.println("running");
	}

}
package com.davesherby.poison.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.davesherby.poison.backend","com.davesherby.poison.shutdowner"})
@SpringBootApplication
public class PoisonBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoisonBackendApplication.class, args);
	}
}

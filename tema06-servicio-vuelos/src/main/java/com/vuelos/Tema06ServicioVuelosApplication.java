package com.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Tema06ServicioVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tema06ServicioVuelosApplication.class, args);
	}

}

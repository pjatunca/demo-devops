package com.example.vuelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Tema06VueloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tema06VueloServiceApplication.class, args);
	}

}

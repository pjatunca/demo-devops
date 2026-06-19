package com.vuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelos.model.Vuelo;
import com.vuelos.services.VueloService;


@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

	@Autowired
	private VueloService service;

	@GetMapping
	public ResponseEntity<List<Vuelo>> listarVuelos() {
		List<Vuelo> vuelos = service.listarVuelos();
		if (vuelos.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(vuelos);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerVueloPorId(@PathVariable int id) {
		Vuelo vuelo = service.obtenerVueloPorId(id);
		if (vuelo == null) {
			return ResponseEntity.
			status(HttpStatus.BAD_REQUEST).body("Producto no existe"); 
		} 
		return ResponseEntity.ok(vuelo); 
	}

	@PostMapping
	public ResponseEntity<Vuelo> agregarVuelo(@RequestBody Vuelo vuelo) {
		try {
			Vuelo nuevo = service.agregarVuelo(vuelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

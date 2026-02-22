package com.example.vuelo.controller;

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

import com.example.vuelo.model.Vuelo;
import com.example.vuelo.services.VueloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

	@Autowired
	private VueloService service;

	@GetMapping
	public ResponseEntity<List<Vuelo>> listarVuelos() {
		log.info("GET /api/vuelos -> Listando vuelos");
		List<Vuelo> vuelos = service.listarVuelos();
		if (vuelos.isEmpty()) {
			log.warn("No se encontraron vuelos registrados");
			return ResponseEntity.noContent().build();
		} 
		log.info("Se encontraron {} vuelos", vuelos.size());
		return ResponseEntity.ok(vuelos);
	}

	@GetMapping("/{id}")
    public ResponseEntity<?> obtenerVueloPorId(@PathVariable int id) {

        log.info("GET /api/vuelos/{} -> Buscando vuelo por ID", id);

        Vuelo vuelo = service.obtenerVueloPorId(id);

        if (vuelo == null) {
            log.warn("Vuelo con ID {} no existe", id);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Vuelo no existe");
        }

        log.info("Vuelo encontrado: {} -> {}", vuelo.getOrigen(), vuelo.getDestino());
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> agregarVuelo(@RequestBody Vuelo vuelo) {

        log.info("POST /api/vuelos -> Agregando vuelo {} -> {}", vuelo.getOrigen(), vuelo.getDestino());
        try {
            Vuelo nuevo = service.agregarVuelo(vuelo);
            log.info("Vuelo agregado exitosamente con ID {}", nuevo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            log.error("Error al agregar vuelo: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

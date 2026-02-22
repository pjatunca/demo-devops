package com.example.vuelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vuelo.model.Vuelo;
import com.example.vuelo.repository.IVueloRepository;



@Service
public class VueloService {

	@Autowired
	private IVueloRepository repoVuelo;


    public List<Vuelo> listarVuelos() {
        return repoVuelo.findAll();
    }

    public Vuelo obtenerVueloPorId(int id) {
        return repoVuelo.findById(id).orElse(null);
    }

    public Vuelo agregarVuelo(Vuelo vuelo) {
        return repoVuelo.save(vuelo);
    }
}
 
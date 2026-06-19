package com.vuelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vuelos.model.Vuelo;


@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer> {
	
}
package com.example.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vuelo.model.Vuelo;



@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer>{

}

package com.springstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springstarter.models.Persona;


@Repository
public interface PersonaService extends JpaRepository<Persona,Long>{

	
}

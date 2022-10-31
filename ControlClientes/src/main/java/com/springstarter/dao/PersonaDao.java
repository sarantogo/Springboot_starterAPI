package com.springstarter.dao;

import org.springframework.data.repository.CrudRepository;

import com.springstarter.domain.Persona;

public interface PersonaDao extends CrudRepository <Persona, Long> {

}

package com.springstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstarter.models.Persona;
import com.springstarter.repository.PersonaService;

@Service
public class PersonaServiceImpl{
	
	@Autowired
	public PersonaService personaService;
	
	@Transactional(readOnly=true)
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaService.findAll();
	}

	@Transactional
	public void guardar(Persona persona) {
		personaService.save(persona);
	}

	@Transactional
	public void eliminar(Persona persona) {
		personaService.delete(persona);
	}

	@Transactional(readOnly=true)
	public Persona encontrarPersona(Persona persona) {
		return personaService.findById(persona.getId_persona()).orElse(null);
	}
}

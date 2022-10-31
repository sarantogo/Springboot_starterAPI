package com.springstarter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springstarter.models.Persona;
import com.springstarter.service.PersonaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired
	private PersonaServiceImpl personaServiceImpl;
	
	@GetMapping("/")
	public String inicio(Model model) {
		var personas = personaServiceImpl.listarPersonas();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "moificar";
	}
	
	@PostMapping("/guardar") 
	public String guardar(@Valid Persona persona, Errors errores) {
		if(errores.hasErrors()) {
			return "moificar";
		}
		personaServiceImpl.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id_persona}")
	public String editar(Persona persona, Model model) {
		persona = personaServiceImpl.encontrarPersona(persona);
		model.addAttribute("persona",persona);
		return "moificar";
	}
	
	@GetMapping("/eliminar/{id_persona}")
	public String eliminar(Persona persona) {
		personaServiceImpl.eliminar(persona);
		return "redirect:/";
	}
}

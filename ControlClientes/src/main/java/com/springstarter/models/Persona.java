package com.springstarter.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity //Para declarar la clase Persona como una entidad en la BD
@Table(name="persona", schema = "C##ANDRES")
public class Persona {
	
	@Id //Para indicar que es la Primary Key
	@GeneratedValue(generator="idPersonaseq") //Para indicar de qué manera se va a generar este valor. En este caso, se va a generar haciendo uso de la secuencia de autoincrement definida en el script SQL. 
	@SequenceGenerator(name="idPersonaseq", sequenceName="PERS_SEQ", allocationSize = 1)
	@Column(name="id_persona")
	private Long id_persona;
	
	@NotEmpty
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="telefono")
	private String telefono;

	public Long getId_persona() {
		return id_persona;
	}

	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	/*public Persona(Long id_persona, String nombre, String apellido, String email, String telefono) {
        this.id_persona=id_persona;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
    }*/
}
package com.uca.capas.labo5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity 
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre")
	@Size(max=20, message="Maximo de 20 caracteres")
	@NotEmpty(message="No puede quedar vacio")
	private String nombre;
	
	@Column(name="apellido")
	@Size(max=20, message="Maximo de 20 caracteres")
	@NotEmpty(message="No puede quedar vacio")
	private String apellido;
	
	@Column(name="carne")
	@Size(min=8, max=8, message="El carnet debe tener 8 caracteres")
	@NotEmpty(message="No puede quedar vacio")
	private String carne;
	
	@Column(name="carrera")
	@Size(max=20, message="Maximo de 20 caracteres")
	@NotEmpty(message="No puede quedar vacio")
	private String carrera;
	
	public Estudiante(){
		
	}
	
	public Estudiante(Integer id,
			@Size(max = 20, message = "Maximo de 20 caracteres") @NotEmpty(message = "No puede quedar vacio") String nombre,
			@Size(max = 20, message = "Maximo de 20 caracteres") @NotEmpty(message = "No puede quedar vacio") String apellido,
			@Size(min = 8, max = 8, message = "El carnet debe tener 8 caracteres") @NotEmpty(message = "No puede quedar vacio") String carne,
			@Size(max = 20, message = "Maximo de 20 caracteres") @NotEmpty(message = "No puede quedar vacio") String carrera) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carne = carne;
		this.carrera = carrera;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
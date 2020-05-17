package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="id_estudiante")
	private Integer codigoEstudiante;
	@Column(name="nombre")
	private String Nombre;
	@Column(name="apellido")
	private String Apellido;
	@Column(name="edad")
	private Integer Edad;
	@Column(name="estado")
	private Boolean Estado;
	
	public Estudiante() {
		
	}
	
	
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	public String getEstadoDelegate() {
		if(this.Estado==null) return "";
		else {
			return Estado ==true ?"Activo":"Inactivo";
		}
	}
	
	
}

package com.uca.capas.labo5.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.labo5.domain.Estudiante;
import com.uca.capas.labo5.dto.EstudianteDTO;

public interface EstudianteService {

	public List<Estudiante> findAll() throws DataAccessException;

	public Estudiante findOne(Integer code) throws DataAccessException;

	public void insert(Estudiante estudiante) throws DataAccessException;

	public void delete(Integer c_usuario) throws DataAccessException;

	public List<Estudiante> filtrar(String cadena) throws DataAccessException;

	public List<Estudiante> Empieza(String cadena) throws DataAccessException;

	public List<EstudianteDTO> dtoPrueba() throws DataAccessException;

	void actualizar(Estudiante estudiante) throws DataAccessException;
}

package com.uca.capas.labo5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.labo5.domain.Estudiante;

public interface EstudianteDAO {
	
	public List<Estudiante>findAll() throws DataAccessException;
	public Estudiante findOne(Integer code) throws DataAccessException;
	public void insert(Estudiante estudiante) throws DataAccessException;
	public void delete(Integer c_usuario) throws DataAccessException;


}

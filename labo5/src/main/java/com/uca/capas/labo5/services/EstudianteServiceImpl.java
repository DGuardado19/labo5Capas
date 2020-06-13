package com.uca.capas.labo5.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.labo5.domain.Estudiante;
import com.uca.capas.labo5.dto.EstudianteDTO;
import com.uca.capas.labo5.repositories.EstudianteRepo;


@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteRepo EstDao;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		// return EstDao.findAll();
		return EstDao.mostrarTodos();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return EstDao.getOne(code);
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		EstDao.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer c_usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		EstDao.deleteById(c_usuario);
	}

	@Override
	@Transactional
	public List<Estudiante> filtrar(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		// return EstDao.findByNombre(caden);
		return EstDao.mostrarPorNombre(cadena);
	}

	@Override
	@Transactional
	public List<Estudiante> Empieza(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return EstDao.findByApellidoStartingWith(cadena);
	}

	@Override
	public List<EstudianteDTO> dtoPrueba() throws DataAccessException {
		List<EstudianteDTO> estudiantes = EstDao.pruebaDTO().stream().map(obj->{
			EstudianteDTO e = new EstudianteDTO();
			e.setNombre(obj[0].toString());
			e.setApellido(obj[1].toString());
			return e;
		}).collect(Collectors.toList());
		return estudiantes;
	}
	

	@Transactional
	public void actualizar(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		EstDao.save(estudiante);
	}
	
}

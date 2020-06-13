package com.uca.capas.labo5.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.labo5.domain.*;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	//tipo de dato de la entidad y el segundo el tipo de dato de la key a la entidad
	
	List<Estudiante>findByNombre(String nombre) throws DataAccessException;
	List<Estudiante>findByApellidoStartingWith(String nombre) throws DataAccessException;
	
	
	@Query(nativeQuery = true, value = "select * from public.estudiante")
	public List<Estudiante>mostrarTodos() throws DataAccessException;
	
	@Query(nativeQuery = true, value = "select * from public.estudiante where nombre = ?1")
	//	@Query(nativeQuery = true, value = "select * from public.estudiante where nombre = :cadena")
	public List<Estudiante>mostrarPorNombre(String cadena) throws DataAccessException;
	
	//dpo
	@Query(nativeQuery=true,value="select nombre, apellido from public.ESTUDIANTE")
	public List<Object[]> pruebaDTO() throws DataAccessException;
	
	@Modifying 
	@Query(nativeQuery = true, value = "Update Estudiante e set e.nombre = ?1, e.apellido = ?2, e.carrera = ?3"
			+ ", e.carrera = ?4 where e.c_usuario = ?5")
	//	@Query(nativeQuery = true, value = "select * from public.estudiante where nombre = :cadena")
	public List<Estudiante>actualizar(String cadena) throws DataAccessException;
	
	
	
}

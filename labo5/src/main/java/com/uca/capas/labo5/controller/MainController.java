package com.uca.capas.labo5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.labo5.domain.Estudiante;
import com.uca.capas.labo5.dto.EstudianteDTO;
import com.uca.capas.labo5.services.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteDA;
	
	
	@RequestMapping("/inicio")
	public ModelAndView initInicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView initdelete() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDA.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudianteslist", estudiantes);
		mav.setViewName("eliminar");
		return mav;
	}
	
	@RequestMapping("/insertarEstudiante")
	public ModelAndView insertar(@Valid @ModelAttribute Estudiante estudiant, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		if(!result.hasErrors()) {
			mav.addObject("estudiante", new Estudiante());
			try {
				estudianteDA.insert(estudiant);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView mostrar() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDA.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudianteslist", estudiantes);
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(@ModelAttribute Estudiante estudiante,@RequestParam(value="cod") int cod) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudianteDA.delete(cod);

		}catch(Exception e ) {
			e.printStackTrace();
		}
		try {
			estudiantes = estudianteDA.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudianteslist", estudiantes);
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("eliminar");
		return mav;
	}
	
	@RequestMapping("/filtrar")
	public ModelAndView filtrar(@RequestParam(value="nombre") String nombre) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteDA.filtrar(nombre);
			//estudiantes = estudianteDA.Empieza(nombre);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		mav.addObject("estudianteslist", estudiantes);
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/mostrarDTO")
	public ModelAndView DTO() {
		ModelAndView mav = new ModelAndView();
		List<EstudianteDTO> estudiantes = null;
		
		try {
			estudiantes = estudianteDA.dtoPrueba();
			//estudiantes = estudianteDA.Empieza(nombre);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		mav.addObject("estudianteslist", estudiantes);
		mav.setViewName("dto");
		return mav;
	}
	
    @RequestMapping("/editarCliente")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Estudiante c = estudianteDA.findOne(id);
		mav.addObject("estudiante", c);
		mav.setViewName("editar");
		return mav;
	}
    
    @RequestMapping("/editar")
 	public ModelAndView guardarCliente(@ModelAttribute Estudiante estudiante) {
 		ModelAndView mav = new ModelAndView();
 		//Mando a llamar al servicio encargado de guardar a la entidad
 		estudianteDA.actualizar(estudiante);
 		mav.setViewName("index");
 		return mav;
 	}

}

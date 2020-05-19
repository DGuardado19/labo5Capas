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

import com.uca.capas.labo5.dao.EstudianteDAO;
import com.uca.capas.labo5.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	
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
			estudiantes = estudianteDAO.findAll();
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
				estudianteDAO.insert(estudiant);
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
			estudiantes = estudianteDAO.findAll();
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
			estudianteDAO.delete(cod);

		}catch(Exception e ) {
			e.printStackTrace();
		}
		try {
			estudiantes = estudianteDAO.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudianteslist", estudiantes);
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("eliminar");
		return mav;
	}
	

}

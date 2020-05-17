package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/estudiante")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes= estudianteDAO.findAll();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = "/mostrarEstudiante", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteDAO.findOne(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("estudiante",estudiante);
		mav.setViewName("estudiante");
		return mav;
	}
	
}

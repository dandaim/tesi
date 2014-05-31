package com.ufrj.dcc.tesi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufrj.dcc.tesi.domain.Professor;
import com.ufrj.dcc.tesi.service.UsuarioService;

@Controller
@RequestMapping( "/professores" )
public class ProfessorController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping( value = "/view", method = RequestMethod.GET )
	public String getProfessoresView( final Model model ) {

		List<Professor> professores = usuarioService.getProfessores();

		model.addAttribute( "professores", professores );

		return "/professores/index";
	}

	@RequestMapping( value = "/professor", method = RequestMethod.GET )
	public String getProfessorView(
			@RequestParam( "professorId" ) Integer professorId, Model model ) {

		Professor professor = usuarioService.getProfessorById( professorId );

		model.addAttribute( "professor", professor );

		return "/professores/professor";
	}
}

package com.ufrj.dcc.tesi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

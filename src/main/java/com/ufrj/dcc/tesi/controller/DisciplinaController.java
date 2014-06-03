package com.ufrj.dcc.tesi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.domain.DisciplinaWrapper;
import com.ufrj.dcc.tesi.service.DisciplinaService;

@Controller
@RequestMapping( "/disciplinas" )
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@RequestMapping( value = "/temas", method = RequestMethod.GET )
	public String getDisciplinaView(
			@RequestParam( "disciplinaId" ) Integer disciplinaId, Model model ) {

		DisciplinaWrapper disciplinaWrapper = disciplinaService
				.getDisciplinaInfo( disciplinaId );

		model.addAttribute( "disciplinaWrapper", disciplinaWrapper );

		return "/disciplinas/temas";
	}

	@RequestMapping( value = "view", method = RequestMethod.GET )
	public String getDisciplinas( Model model ) {

		List<Disciplina> disciplinas = disciplinaService.getDisciplinas();

		model.addAttribute( "disciplinas", disciplinas );

		return "/disciplinas/index";
	}

	@RequestMapping( value = "avaliacoes", method = RequestMethod.GET )
	public String getAvaliacoes(
			@RequestParam( "disciplinaId" ) Integer disciplinaId, Model model ) {

		DisciplinaWrapper disciplinaWrapper = disciplinaService
				.getAvaliacoesDisciplina( disciplinaId );

		model.addAttribute( "disciplinaWrapper", disciplinaWrapper );

		return "/disciplinas/avaliacoes";

	}
}

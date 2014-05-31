package com.ufrj.dcc.tesi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

}

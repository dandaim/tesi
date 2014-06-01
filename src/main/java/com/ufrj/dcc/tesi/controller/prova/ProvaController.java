package com.ufrj.dcc.tesi.controller.prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufrj.dcc.tesi.domain.ProvaWrapper;
import com.ufrj.dcc.tesi.service.ProvaService;

@Controller
@RequestMapping( "/provas" )
public class ProvaController {

	@Autowired
	private ProvaService provaService;

	@RequestMapping( value = "/prova", method = RequestMethod.GET )
	public String getView( @RequestParam( "provaId" ) final Integer provaId,
			final Model model ) {

		ProvaWrapper provaWrapper = provaService.getProvaInfo( provaId );

		model.addAttribute( "provaWrapper", provaWrapper );

		return "/provas/prova";
	}

}

package com.ufrj.dcc.tesi.controller.prova;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufrj.dcc.tesi.controller.prova.form.ProvaForm;

@Controller
@RequestMapping( "/prova" )
public class ProvaController {

	@RequestMapping( value = "/view", method = RequestMethod.GET )
	public String getView( final Model model ) {

		model.addAttribute( "provaForm", new ProvaForm() );

		return "/index";
	}

	@RequestMapping( value = "/request", method = RequestMethod.POST )
	public String submitForm( final ProvaForm provaForm, final Model model ) {

		return "";
	}

}

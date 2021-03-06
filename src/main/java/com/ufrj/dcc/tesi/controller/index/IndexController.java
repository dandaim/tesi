package com.ufrj.dcc.tesi.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufrj.dcc.tesi.controller.index.form.IndexForm;
import com.ufrj.dcc.tesi.service.UsuarioService;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.User;
import facebook4j.auth.AccessToken;

@Controller
@RequestMapping( "/index" )
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;

	final static String appId = "252774131593896";
	final static String appSecret = "1777932d489db9415b00e59fd7904aeb";

	@RequestMapping( value = "", method = RequestMethod.GET )
	public String getView( final Model model ) throws FacebookException {

		model.addAttribute( "indexForm", new IndexForm() );

		return "/index";
	}

	@RequestMapping( method = RequestMethod.POST )
	public String submit( final IndexForm indexForm, final Model model,
			final HttpServletRequest request ) {

		Facebook facebook = new FacebookFactory().getInstance();

		facebook.setOAuthAppId( appId, appSecret );
		facebook.setOAuthAccessToken( new AccessToken( indexForm
				.getAccessToken() ) );

		try {

			User user = facebook.getMe();

			return usuarioService.loginUser( user, request );

		} catch ( FacebookException e ) {

			e.printStackTrace();
		}

		return "/index";
	}
}

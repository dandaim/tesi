package com.ufrj.dcc.tesi.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Usuario;

@Service
public class SessionService {

	public boolean isLoggedIn( final HttpServletRequest request ) {

		Usuario usuario = ( Usuario ) request.getSession().getAttribute(
				"usuario" );

		return usuario != null;
	}

	public void loginUser( Usuario usuario, HttpServletRequest request ) {

		request.getSession().setAttribute( "usuario", usuario );
	}
}

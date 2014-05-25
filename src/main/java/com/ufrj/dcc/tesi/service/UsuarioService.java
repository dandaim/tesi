package com.ufrj.dcc.tesi.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Usuario;
import com.ufrj.dcc.tesi.repository.UsuarioRepository;

import facebook4j.User;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findUsuarioByFacebookId( String facebookId ) {

		return usuarioRepository.findUsuarioByFacebookId( facebookId );

	}

	public String loginUser( User user, HttpServletRequest request ) {

		Usuario usuario = this.findUsuarioByFacebookId( user.getId() );

		if ( usuario == null ) {

			int idUsuario = usuarioRepository.insertUsuario( user );

			usuario = new Usuario( user, idUsuario );
		}

		request.getSession().setAttribute( "usuario", usuario );

		return "/home";
	}

}

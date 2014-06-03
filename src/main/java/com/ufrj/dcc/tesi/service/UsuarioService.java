package com.ufrj.dcc.tesi.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.domain.Professor;
import com.ufrj.dcc.tesi.domain.Usuario;
import com.ufrj.dcc.tesi.repository.UsuarioRepository;

import facebook4j.User;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DisciplinaService disciplinaService;

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

	public List<Professor> getProfessores() {

		List<Usuario> professores = usuarioRepository.getProfessores();

		List<Professor> result = new ArrayList<Professor>();

		for ( Usuario usuario : professores ) {

			List<Disciplina> disciplinas = disciplinaService
					.getDisciplinasByProfessor( usuario.getId() );

			Professor professor = new Professor( usuario, disciplinas );

			result.add( professor );
		}

		return result;
	}

	public Professor getProfessorById( Integer professorId ) {

		Usuario usuario = usuarioRepository.findUsuarioById( professorId );

		List<Disciplina> disciplinas = disciplinaService
				.getDisciplinasByProfessor( professorId );

		Professor professor = new Professor( usuario, disciplinas );

		return professor;
	}

	public List<Usuario> getProfessoresByDisciplinaId( Integer disciplinaId ) {

		List<Usuario> professores = usuarioRepository
				.getProfessoresByDisciplinaId( disciplinaId );

		return professores;
	}
}

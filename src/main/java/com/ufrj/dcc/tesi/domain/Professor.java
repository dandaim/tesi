package com.ufrj.dcc.tesi.domain;

import java.util.List;

public class Professor extends Usuario {

	List<Disciplina> disciplinas;

	public Professor( Usuario usuario, List<Disciplina> disciplinas ) {
		super( usuario.getId(), usuario.getIdFacebook(), usuario
				.getTipoUsuario(), usuario.getNomeFace() );
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas( List<Disciplina> disciplinas ) {
		this.disciplinas = disciplinas;
	}

}

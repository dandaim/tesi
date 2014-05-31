package com.ufrj.dcc.tesi.domain;

import java.util.List;

public class DisciplinaWrapper {

	private Disciplina disciplina;
	private List<Usuario> professores;
	private List<Tema> temas;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina( Disciplina disciplina ) {
		this.disciplina = disciplina;
	}

	public List<Usuario> getProfessores() {
		return professores;
	}

	public void setProfessores( List<Usuario> professores ) {
		this.professores = professores;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas( List<Tema> temas ) {
		this.temas = temas;
	}

}

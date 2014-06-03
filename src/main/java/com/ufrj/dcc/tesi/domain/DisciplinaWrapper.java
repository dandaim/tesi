package com.ufrj.dcc.tesi.domain;

import java.util.List;
import java.util.Map;

public class DisciplinaWrapper {

	private Disciplina disciplina;
	private List<Usuario> professores;
	private List<Tema> temas;
	private Map<Integer, List<Prova>> provas;

	public Map<Integer, List<Prova>> getProvas() {
		return provas;
	}

	public void setProvas( Map<Integer, List<Prova>> provas ) {
		this.provas = provas;
	}

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

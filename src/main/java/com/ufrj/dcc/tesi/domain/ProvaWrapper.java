package com.ufrj.dcc.tesi.domain;

import java.util.List;

public class ProvaWrapper {

	private Prova prova;
	private List<Tema> temas;
	private Disciplina disciplina;

	public Prova getProva() {
		return prova;
	}

	public void setProva( Prova prova ) {
		this.prova = prova;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas( List<Tema> temas ) {
		this.temas = temas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina( Disciplina disciplina ) {
		this.disciplina = disciplina;
	}

}

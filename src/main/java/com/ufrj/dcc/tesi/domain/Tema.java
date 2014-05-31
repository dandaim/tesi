package com.ufrj.dcc.tesi.domain;

import java.util.List;

public class Tema {

	private Integer id;
	private String nome;
	private Integer disciplinaId;
	private List<Prova> provas;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public Integer getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId( Integer disciplinaId ) {
		this.disciplinaId = disciplinaId;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas( List<Prova> provas ) {
		this.provas = provas;
	}

}

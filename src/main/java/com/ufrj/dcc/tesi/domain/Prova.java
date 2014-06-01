package com.ufrj.dcc.tesi.domain;

public class Prova {

	private Integer id;
	private String src;
	private String ano;
	private String periodo;
	private Integer idUsuario;
	private Integer idDisciplina;
	private Integer idProfessor;
	private String nomeProfessor;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc( String src ) {
		this.src = src;
	}

	public String getAno() {
		return ano;
	}

	public void setAno( String ano ) {
		this.ano = ano;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo( String periodo ) {
		this.periodo = periodo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario( Integer idUsuario ) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina( Integer idDisciplina ) {
		this.idDisciplina = idDisciplina;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor( Integer idProfessor ) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor( String nomeProfessor ) {
		this.nomeProfessor = nomeProfessor;
	}
}

package com.ufrj.dcc.tesi.controller.prova.form;

import com.ufrj.dcc.tesi.domain.Period;

public class ProvaForm {

	private Long id;
	private String source;
	private Integer year;
	private Period period;
	private Integer disciplinaId;
	private Integer professorId;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource( String source ) {
		this.source = source;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear( Integer year ) {
		this.year = year;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod( Period period ) {
		this.period = period;
	}

	public Integer getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId( Integer disciplinaId ) {
		this.disciplinaId = disciplinaId;
	}

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId( Integer professorId ) {
		this.professorId = professorId;
	}

}

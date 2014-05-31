package com.ufrj.dcc.tesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.domain.DisciplinaWrapper;
import com.ufrj.dcc.tesi.domain.Prova;
import com.ufrj.dcc.tesi.domain.Tema;
import com.ufrj.dcc.tesi.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private TemaService temaService;

	@Autowired
	private ProvaService provaService;

	public List<Disciplina> getDisciplinasByProfessor( Integer usuarioId ) {

		return disciplinaRepository.getDisciplinasByProfessor( usuarioId );
	}

	public DisciplinaWrapper getDisciplinaInfo( Integer disciplinaId ) {

		DisciplinaWrapper disciplinaWrapper = new DisciplinaWrapper();

		Disciplina disciplina = disciplinaRepository
				.getDisciplinaById( disciplinaId );

		List<Tema> temas = temaService.getTemasByDisciplinaId( disciplinaId );

		for ( Tema tema : temas ) {

			List<Prova> provas = provaService.getProvasByTemaId( tema.getId() );
			tema.setProvas( provas );
		}

		disciplinaWrapper.setTemas( temas );
		disciplinaWrapper.setDisciplina( disciplina );

		return disciplinaWrapper;
	}
}

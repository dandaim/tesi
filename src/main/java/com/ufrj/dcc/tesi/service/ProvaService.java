package com.ufrj.dcc.tesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.domain.Prova;
import com.ufrj.dcc.tesi.domain.ProvaWrapper;
import com.ufrj.dcc.tesi.domain.Tema;
import com.ufrj.dcc.tesi.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository provaRepository;

	@Autowired
	private TemaService temaService;

	@Autowired
	private DisciplinaService disciplinaService;

	public List<Prova> getProvasByTemaId( Integer temaId ) {

		return provaRepository.getProvasByTemaId( temaId );

	}

	public ProvaWrapper getProvaInfo( Integer provaId ) {

		ProvaWrapper provaWrapper = new ProvaWrapper();

		Prova prova = provaRepository.getProvaById( provaId );

		List<Tema> temas = temaService.getTemasByProvaId( provaId );

		Disciplina disciplina = disciplinaService.getDisciplinaById( prova
				.getIdDisciplina() );

		provaWrapper.setProva( prova );
		provaWrapper.setTemas( temas );
		provaWrapper.setDisciplina( disciplina );

		return provaWrapper;
	}
}

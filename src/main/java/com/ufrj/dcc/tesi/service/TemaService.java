package com.ufrj.dcc.tesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Tema;
import com.ufrj.dcc.tesi.repository.TemaRepository;

@Service
public class TemaService {

	@Autowired
	private TemaRepository temaRepository;

	public List<Tema> getTemasByDisciplinaId( Integer disciplinaId ) {

		return temaRepository.getTemasByDisciplinaId( disciplinaId );

	}

	public List<Tema> getTemasByProvaId( Integer provaId ) {

		return temaRepository.getTemasByProvaId( provaId );

	}

}

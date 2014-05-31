package com.ufrj.dcc.tesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Prova;
import com.ufrj.dcc.tesi.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository provaRepository;

	public List<Prova> getProvasByTemaId( Integer temaId ) {

		return provaRepository.getProvasByTemaId( temaId );

	}

}

package com.ufrj.dcc.tesi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.domain.DisciplinaWrapper;
import com.ufrj.dcc.tesi.domain.Prova;
import com.ufrj.dcc.tesi.domain.Tema;
import com.ufrj.dcc.tesi.domain.Usuario;
import com.ufrj.dcc.tesi.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private TemaService temaService;

	@Autowired
	private ProvaService provaService;

	@Autowired
	private UsuarioService usuarioService;

	public List<Disciplina> getDisciplinas() {

		return disciplinaRepository.getDisciplinas();
	}

	public List<Disciplina> getDisciplinasByProfessor( Integer usuarioId ) {

		return disciplinaRepository.getDisciplinasByProfessor( usuarioId );
	}

	public Disciplina getDisciplinaById( Integer disciplinaId ) {

		return disciplinaRepository.getDisciplinaById( disciplinaId );
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

	public DisciplinaWrapper getAvaliacoesDisciplina( Integer disciplinaId ) {

		DisciplinaWrapper disciplinaWrapper = new DisciplinaWrapper();

		Disciplina disciplina = disciplinaRepository
				.getDisciplinaById( disciplinaId );

		List<Usuario> professores = usuarioService
				.getProfessoresByDisciplinaId( disciplinaId );

		Map<Integer, List<Prova>> provas = new HashMap<Integer, List<Prova>>();

		for ( Usuario professor : professores ) {

			List<Prova> provasProfessor = provaService
					.getProvasByProfessorId( professor.getId() );

			provas.put( professor.getId(), provasProfessor );
		}

		disciplinaWrapper.setDisciplina( disciplina );
		disciplinaWrapper.setProfessores( professores );
		disciplinaWrapper.setProvas( provas );

		return disciplinaWrapper;
	}
}

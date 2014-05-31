package com.ufrj.dcc.tesi.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ufrj.dcc.tesi.domain.Disciplina;
import com.ufrj.dcc.tesi.repository.rowMapper.DisciplinaRowMapper;

@Repository
public class DisciplinaRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource( DataSource dataSource ) {

		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}

	public List<Disciplina> getDisciplinasByProfessor( Integer professorId ) {

		String query = "SELECT d.* FROM disciplina d "
				+ " INNER JOIN disciplinaProfessor dp ON d.id = dp.disciplina_id "
				+ " WHERE dp.usuario_id = ?";

		List<Disciplina> disciplinaList = jdbcTemplate.query( query,
				new Object[] { professorId }, new DisciplinaRowMapper() );

		return disciplinaList;
	}

	public Disciplina getDisciplinaById( Integer disciplinaId ) {

		String query = "SELECT * FROM disciplina WHERE id = ?";

		List<Disciplina> disciplinaList = jdbcTemplate.query( query,
				new Object[] { disciplinaId }, new DisciplinaRowMapper() );

		return disciplinaList.iterator().hasNext() ? disciplinaList.iterator()
				.next() : null;
	}

}

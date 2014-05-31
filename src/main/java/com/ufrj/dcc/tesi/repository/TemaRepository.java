package com.ufrj.dcc.tesi.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ufrj.dcc.tesi.domain.Tema;
import com.ufrj.dcc.tesi.repository.rowMapper.TemaRowMapper;

@Repository
public class TemaRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource( DataSource dataSource ) {

		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}

	public List<Tema> getTemasByDisciplinaId( Integer disciplinaId ) {

		String query = "SELECT * FROM tema WHERE disciplina_id = ?";

		List<Tema> temaList = jdbcTemplate.query( query,
				new Object[] { disciplinaId }, new TemaRowMapper() );

		return temaList;
	}

}

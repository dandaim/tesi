package com.ufrj.dcc.tesi.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ufrj.dcc.tesi.domain.Prova;
import com.ufrj.dcc.tesi.repository.rowMapper.ProvaRowMapper;

@Repository
public class ProvaRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource( DataSource dataSource ) {

		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}

	public List<Prova> getProvasByTemaId( Integer temaId ) {

		String query = "SELECT p.*, uf.nomeFace FROM prova p INNER JOIN provaTema pt ON p.id = pt.prova_id "
				+ " INNER JOIN usuario pr ON p.professor_id = pr.id INNER JOIN usuarioFacebook uf ON uf.usuario_id = pr.id"
				+ " WHERE pt.tema_id = ?";

		List<Prova> provas = jdbcTemplate.query( query,
				new Object[] { temaId }, new ProvaRowMapper() );

		return provas;
	}

	public Prova getProvaById( Integer provaId ) {

		String query = "SELECT p.*, uf.nomeFace FROM prova p "
				+ " INNER JOIN usuario pr ON p.professor_id = pr.id INNER JOIN usuarioFacebook uf ON uf.usuario_id = pr.id"
				+ " WHERE p.id = ?";

		List<Prova> provas = jdbcTemplate.query( query,
				new Object[] { provaId }, new ProvaRowMapper() );

		return provas.iterator().hasNext() ? provas.iterator().next() : null;
	}

	public List<Prova> getProvasByProfessorId( Integer professorId ) {

		String query = "SELECT p.*, uf.nomeFace FROM prova p "
				+ " INNER JOIN usuario pr ON p.professor_id = pr.id INNER JOIN usuarioFacebook uf ON uf.usuario_id = pr.id"
				+ " WHERE p.professor_id = ?";

		List<Prova> provas = jdbcTemplate.query( query,
				new Object[] { professorId }, new ProvaRowMapper() );

		return provas;
	}

}

package com.ufrj.dcc.tesi.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ufrj.dcc.tesi.domain.Disciplina;

public class DisciplinaRowMapper implements RowMapper<Disciplina> {

	@Override
	public Disciplina mapRow( ResultSet rs, int row ) throws SQLException {

		Disciplina disciplina = new Disciplina();

		disciplina.setDisciplinaId( rs.getInt( "id" ) );
		disciplina.setNome( rs.getString( "nome" ) );

		return disciplina;
	}

}

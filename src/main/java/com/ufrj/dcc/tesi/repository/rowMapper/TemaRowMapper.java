package com.ufrj.dcc.tesi.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ufrj.dcc.tesi.domain.Tema;

public class TemaRowMapper implements RowMapper<Tema> {

	@Override
	public Tema mapRow( ResultSet rs, int arg1 ) throws SQLException {

		Tema tema = new Tema();

		tema.setDisciplinaId( rs.getInt( "disciplina_id" ) );
		tema.setId( rs.getInt( "id" ) );
		tema.setNome( rs.getString( "nome" ) );

		return tema;
	}

}

package com.ufrj.dcc.tesi.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ufrj.dcc.tesi.domain.Prova;

public class ProvaRowMapper implements RowMapper<Prova> {

	@Override
	public Prova mapRow( ResultSet rs, int row ) throws SQLException {

		Prova prova = new Prova();

		prova.setAno( rs.getString( "ano" ) );
		prova.setId( rs.getInt( "id" ) );
		prova.setIdDisciplina( rs.getInt( "disciplina_id" ) );
		prova.setIdProfessor( rs.getInt( "professor_id" ) );
		prova.setIdUsuario( rs.getInt( "usuario_id" ) );
		prova.setPeriodo( rs.getString( "periodo" ) );
		prova.setSrc( rs.getString( "src" ) );

		return prova;
	}

}

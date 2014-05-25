package com.ufrj.dcc.tesi.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ufrj.dcc.tesi.domain.TipoUsuarioEnum;
import com.ufrj.dcc.tesi.domain.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow( ResultSet rs, int row ) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setId( rs.getInt( "id" ) );
		usuario.setIdFacebook( rs.getString( "idFacebook" ) );
		usuario.setNomeFace( rs.getString( "nomeFace" ) );
		usuario.setTipoUsuario( TipoUsuarioEnum.getTipoUsuario( rs
				.getString( "tipo" ) ) );

		return usuario;
	}

}

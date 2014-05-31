package com.ufrj.dcc.tesi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ufrj.dcc.tesi.domain.TipoUsuarioEnum;
import com.ufrj.dcc.tesi.domain.Usuario;
import com.ufrj.dcc.tesi.repository.rowMapper.UsuarioRowMapper;

import facebook4j.User;

@Repository
public class UsuarioRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource( DataSource dataSource ) {

		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}

	public Usuario findUsuarioByFacebookId( String facebookId ) {

		String query = "SELECT * FROM usuario u INNER JOIN usuarioFacebook uf ON u.id = uf.usuario_id WHERE u.idFacebook = ?";

		List<Usuario> usuarioList = jdbcTemplate.query( query,
				new Object[] { facebookId }, new UsuarioRowMapper() );

		return usuarioList.iterator().hasNext() ? usuarioList.iterator().next()
				: null;
	}

	public Usuario findUsuarioById( Integer id ) {

		String query = "SELECT * FROM usuario u INNER JOIN usuarioFacebook uf ON u.id = uf.usuario_id WHERE u.id = ?";

		List<Usuario> usuarioList = jdbcTemplate.query( query,
				new Object[] { id }, new UsuarioRowMapper() );

		return usuarioList.iterator().hasNext() ? usuarioList.iterator().next()
				: null;
	}

	public int insertUsuario( final User user ) {

		final String query = "INSERT INTO usuario (idFacebook, tipo) VALUES (?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int id = this.jdbcTemplate.update( new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection ) throws SQLException {

				PreparedStatement ps = connection.prepareStatement( query );
				ps.setString( 1, user.getId() );
				ps.setString( 2, TipoUsuarioEnum.USUARIO.toString() );

				return ps;
			}
		}, keyHolder );

		String queryFacebook = "INSERT INTO usuarioFacebook (idFace, nomeFace, usuario_id) VALUES (?,?,?)";

		this.jdbcTemplate.update( queryFacebook, new Object[] { user.getId(),
				user.getName(), id } );

		return id;
	}

	public List<Usuario> getProfessores() {

		String query = "SELECT * FROM usuario u INNER JOIN usuarioFacebook uf ON u.id = "
				+ " uf.usuario_id WHERE u.tipo = ?";

		List<Usuario> usuarioList = jdbcTemplate.query( query,
				new Object[] { TipoUsuarioEnum.PROFESSOR.toString() },
				new UsuarioRowMapper() );

		return usuarioList;

	}
}

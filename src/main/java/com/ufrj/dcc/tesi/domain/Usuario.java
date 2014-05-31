package com.ufrj.dcc.tesi.domain;

import facebook4j.User;

public class Usuario {

	private Integer id;
	private String idFacebook;
	private TipoUsuarioEnum tipoUsuario;
	private String nomeFace;

	public Usuario() {
		super();
	}

	public Usuario( Integer id, String idFacebook, TipoUsuarioEnum tipoUsuario,
			String nomeFace ) {
		super();
		this.id = id;
		this.idFacebook = idFacebook;
		this.tipoUsuario = tipoUsuario;
		this.nomeFace = nomeFace;
	}

	public Usuario( User user, Integer id ) {

		this.id = id;
		this.idFacebook = user.getId();
		this.nomeFace = user.getName();
		this.tipoUsuario = TipoUsuarioEnum.USUARIO;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idFacebook=" + idFacebook
				+ ", tipoUsuario=" + tipoUsuario + ", nomeFace=" + nomeFace
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook( String idFacebook ) {
		this.idFacebook = idFacebook;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario( TipoUsuarioEnum tipoUsuario ) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeFace() {
		return nomeFace;
	}

	public void setNomeFace( String nomeFace ) {
		this.nomeFace = nomeFace;
	}

}

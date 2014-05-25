package com.ufrj.dcc.tesi.domain;

public enum TipoUsuarioEnum {

	USUARIO, PROFESSOR, ADMIN;

	public static TipoUsuarioEnum getTipoUsuario( String tipo ) {

		for ( TipoUsuarioEnum tipoUsuario : TipoUsuarioEnum.values() ) {

			if ( tipoUsuario.toString().equals( tipo ) ) {
				return tipoUsuario;
			}

		}

		return USUARIO;
	}
}

package carros.regras.security;

import java.sql.ResultSet;

import carros.entities.usuarios.TipoUsuario;

public interface TipoUsuarioRegra {
	public TipoUsuario buildTipoUsuario(ResultSet rs);
}

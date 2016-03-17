package carros.regras.security;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.TipoUsuario;

public interface TipoUsuarioRegra {
	public TipoUsuario buildTipoUsuario(ResultSet rs);

	public TipoUsuario buildTipoUsuario(Map<String, Object> row);
}

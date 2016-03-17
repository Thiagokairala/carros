package carros.regras.security;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.Usuario;

public interface UsuarioRegra {
	
	public Usuario buildUsuario(ResultSet rs);

	public Usuario buildUsuario(Map<String, Object> row);

}

package carros.rule.security;

import java.sql.ResultSet;

import carros.entities.usuarios.Usuario;

public interface UsuarioRegra {
	
	public Usuario buildUsuario(ResultSet rs);

}

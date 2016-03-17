package carros.regras.security;

import java.sql.ResultSet;

import carros.entities.usuarios.Usuario;

public interface UsuarioRegra {
	
	public Usuario buildUsuario(ResultSet rs);

}

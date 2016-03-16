package carros.dao.security;

import carros.entities.security.LoginForm;
import carros.entities.usuarios.Usuario;

public interface UsuarioDao {
	public Usuario inserirUsuario(Usuario usuario);

	public Usuario loginUsuario(LoginForm loginForm);
}

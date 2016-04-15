package carros.dao.security;

import carros.entities.security.LoginForm;
import carros.entities.usuarios.Usuario;
import carros.exception.security.CarrosUserNotFound;

public interface UsuarioDao {
	public Usuario inserirUsuario(Usuario usuario) throws Exception;

	public Usuario loginUsuario(LoginForm loginForm);

	public Usuario loginUsuario(String token);

	public void setarAutenticado(Long idUsuario);

	public void updateUsuario(Usuario usuario);

	public void trocarStatusUsuairo(Usuario usuario);

	public void verificarSenhaAtual(Long idUsuario, String senhaAntiga);

	public void trocarSenha(Long long1, String criptografarSenha);

	public Usuario buscarUsuarioPorEmail(String email) throws CarrosUserNotFound;

	public void inserirTokenEsqueciSenha(String hash, Long idUsuario);

	public Usuario verificarTokenEsqueciSenha(String token) throws CarrosUserNotFound;
}

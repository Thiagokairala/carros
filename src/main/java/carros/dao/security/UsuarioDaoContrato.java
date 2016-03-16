package carros.dao.security;

public final class UsuarioDaoContrato {
	public static String INSERIR_USUARIO = "INSERT INTO usuario (txt_nome_usuario, "
			+ "txt_senha_usuario, pessoa_idpessoa, txt_email) VALUES " + "(?, ?, ?, ?)";
	public static String BUSCAR_USUARIO = "SELECT * FROM usuario WHERE txt_nome_usuario = ? AND txt_senha_usuario = ?";
}

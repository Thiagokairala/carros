package carros.dao.security;

public final class UsuarioDaoContrato {
	public static final String BUSCAR_USUARIO_TOKEN = "SELECT * FROM usuario " + "JOIN tipo_usuario "
			+ "ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "WHERE txt_token_autenticacao = ?";
	public static final String SETAR_AUTENTICADO = "UPDATE usuario " + "SET bool_autenticado = true "
			+ "WHERE idusuario = ?";
	public static final String TROCAR_STATUS_USUARIO = "UPDATE usuario SET bool_ativo = ? WHERE idusuario = ?";
	public static final String BUSCAR_EMAIL = "SELECT * FROM usuario WHERE txt_email = ?";
	public static final String BUSCAR_USERNAME = "SELECT * FROM usuario WHERE txt_nome_usuario =?";
	public static String INSERIR_USUARIO = "INSERT INTO usuario (txt_nome_usuario, "
			+ "txt_senha_usuario, pessoa_idpessoa, txt_email, tipo_usuario_idtipo_usuario, txt_token_autenticacao) VALUES "
			+ "(?, ?, ?, ?, ?, ?)";
	public static String BUSCAR_USUARIO = "SELECT * FROM usuario " + "JOIN tipo_usuario "
			+ "ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "WHERE txt_nome_usuario = ? AND txt_senha_usuario = ? AND bool_ativo = true";
}

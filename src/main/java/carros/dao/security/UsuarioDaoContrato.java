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
	public static final String VERIFICAR_SENHA = "SELECT * FROM usuario WHERE idusuario = ? AND txt_senha_usuario = ?";
	public static final String TROCAR_SENHA = "UPDATE usuario SET txt_senha_usuario = ? WHERE idusuario = ?";
	public static final String INSERIR_TOKEN_ESQUECI_SENHA = "INSERT INTO esqueci_senha_token (txt_token, usuario_idusuario) VALUES (?, ?)";
	public static final String BUSCAR_USUARIO_POR_TOKEN_ESQUECI_SENHA = "SELECT * FROM usuario "
			+ "JOIN esqueci_senha_token "
			+ "ON usuario.idusuario = esqueci_senha_token.usuario_idusuario "
			+ "WHERE txt_token = ? AND bool_usado = false";
	public static final String INSERIR_USUARIO_JA_AUTENTICADO = "INSERT INTO usuario (txt_nome_usuario, "
			+ "txt_senha_usuario, pessoa_idpessoa, txt_email, tipo_usuario_idtipo_usuario, txt_token_autenticacao, bool_ativo, bool_autenticado) VALUES "
			+ "(?, ?, ?, ?, ?, ?, true, true)";
	public static String INSERIR_USUARIO = "INSERT INTO usuario (txt_nome_usuario, "
			+ "txt_senha_usuario, pessoa_idpessoa, txt_email, tipo_usuario_idtipo_usuario, txt_token_autenticacao, bool_ativo) VALUES "
			+ "(?, ?, ?, ?, ?, ?, true)";
	public static String BUSCAR_USUARIO = "SELECT * FROM usuario " + "JOIN tipo_usuario "
			+ "ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "WHERE txt_nome_usuario = ? AND txt_senha_usuario = ? AND bool_ativo = true";
}

package carros.dao.negocio;

public final class ChatDaoContrato {

	public static final String INSERIR_CHAT = "INSERT INTO chat " + "(txt_nome, lojista_idlojista) " + "VALUES (?, ?)";
	public static final String BUSCAR_USUARIOS_CHAT = "SELECT * " + "FROM chat_inclui_usuario_concessionaria "
			+ "JOIN usuario_concessionaria " + "ON usuario_concessionaria.idusuario_concessionaria = "
			+ "chat_inclui_usuario_concessionaria.usuario_concessionaria_idusuario_concessionaria "
			+ "JOIN usuario ON usuario.idusuario = usuario_concessionaria.usuario_idusuario " + "WHERE chat_idchat = ?";
	public static final String INSERIR_USUARIO_CHAT = "INSERT INTO chat_inclui_usuario_concessionaria "
			+ "(chat_idchat, usuario_concessionaria_idusuario_concessionaria) VALUES (?, ?)";
	public static final String GET_TODOS_CHATS_LOJISTA = "SELECT * FROM chat WHERE lojista_idlojista = ? "
			+ "AND bool_finalizado = false";
	public static final String GET_TODOS_CHATS_USUARIO_CONCESSIONARIA = "SELECT * FROM chat "
			+ "JOIN chat_inclui_usuario_concessionaria ON chat_inclui_usuario_concessionaria.chat_idchat = chat.idchat "
			+ "WHERE chat_inclui_usuario_concessionaria.usuario_concessionaria_idusuario_concessionaria = ? AND bool_finalizado = false";
	public static final String BUSCAR_CHAT_POR_ID = "SELECT * FROM chat "
			+ "JOIN lojista ON chat.lojista_idlojista = lojista.idlojista "
			+ "JOIN usuario ON lojista.usuario_idusuario = usuario.idusuario " + "WHERE idchat = ?";
	public static final String FINALIZAR_CHAT = "UPDATE chat SET bool_finalizado=true WHERE idchat = ?";
	public static final String BUSCAR_CHAT_POR_OFERTA = "SELECT chat_idchat AS idchat FROM lojista_fez_oferta "
			+ "WHERE oferta_idoferta = ?";

}

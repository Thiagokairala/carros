package carros.dao.negocio;

public final class MensagemDaoContrato {

	protected static final String INSERIR_MENSAGEM = "INSERT INTO mensagem ("
			+ "	txt_mensagem, dt_envio, usuario_idusuario, chat_idchat, txt_nomeDeTela, imagem_idimagem"
			+ ") VALUES (?, now(), ?, ?, ?, ?)";
	public static final String GET_MENSAGENS_CHAT = "SELECT * FROM mensagem "
			+ "JOIN chat ON mensagem.chat_idchat = chat.idchat "
			+ "JOIN imagem ON mensagem.imagem_idimagem = imagem.idimagem "
			+ "JOIN usuario ON usuario.idusuario = mensagem.usuario_idusuario "
			+ "WHERE chat_idchat = ?";

}

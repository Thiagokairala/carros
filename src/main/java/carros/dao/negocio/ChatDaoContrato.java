package carros.dao.negocio;

public final class ChatDaoContrato {

	public static final String INSERIR_CHAT = "INSERT INTO chat "
			+ "(txt_nome, lojista_idlojista) "
			+ "VALUES (?, ?)";

}

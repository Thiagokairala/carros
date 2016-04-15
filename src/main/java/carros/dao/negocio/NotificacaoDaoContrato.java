package carros.dao.negocio;

public class NotificacaoDaoContrato {

	public static final String INSERIR_NOTIFICACAO = "INSERT INTO notificacao "
			+ "(usuario_idusuario, txt_titulo, txt_corpo) " + "VALUES (?, ?, ?)";
	public static final String BUSCAR_NOTIFICACOES = "SELECT * FROM notificacao WHERE usuario_idusuario = ? LIMIT ?, ?";

}

package carros.dao.negocio;

public class NotificacaoDaoContrato {

	public static final String INSERIR_NOTIFICACAO = "INSERT INTO notificacao "
			+ "(usuario_idusuario, txt_titulo, txt_corpo) "
			+ "VALUES (?, ?, ?)";

}

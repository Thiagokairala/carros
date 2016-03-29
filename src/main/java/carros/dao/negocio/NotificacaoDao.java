package carros.dao.negocio;

public interface NotificacaoDao {

	public void criarNotificacao(Long idDestinatario, String titulo, String corpo);

}

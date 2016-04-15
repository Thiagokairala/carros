package carros.dao.negocio;

import java.util.List;

import carros.entities.comunicacao.Notificacao;

public interface NotificacaoDao {

	public void criarNotificacao(Long idDestinatario, String titulo, String corpo);

	public List<Notificacao> getNotificacoesUsuario(Long userId, int pagina);

}

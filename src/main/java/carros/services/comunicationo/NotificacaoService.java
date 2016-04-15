package carros.services.comunicationo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.NotificacaoDao;
import carros.entities.comunicacao.Notificacao;
import carros.util.Paginacao;

@Service
public class NotificacaoService {
	private NotificacaoDao notificacaoDao;

	public List<Notificacao> getNotificacoes(Long userId, int pagina) {

		pagina *= Paginacao.TAMANHO_PAGINA;
		return notificacaoDao.getNotificacoesUsuario(userId, pagina);
	}

	@Autowired
	public void setNotificacaoDao(NotificacaoDao notificacaoDao) {
		this.notificacaoDao = notificacaoDao;
	}

}

package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.controllers.comunication.ChatSocketController;
import carros.entities.comunicacao.Notificacao;
import carros.regras.negocio.NotificacaoRegra;
import carros.util.Paginacao;

@Repository
public class NotificacaoDaoImpl implements NotificacaoDao {

	private JdbcTemplate jdbcTemplate;
	private ChatSocketController chatSocketController;
	private NotificacaoRegra notificacaoRegra;

	@Override
	public void criarNotificacao(Long idDestinatario, String titulo, String corpo) {
		Object[] paramsList = new Object[] { idDestinatario, titulo, corpo };
		jdbcTemplate.update(NotificacaoDaoContrato.INSERIR_NOTIFICACAO, paramsList);
		chatSocketController.sendNotificacao(idDestinatario, titulo, corpo);
	}

	@Override
	public List<Notificacao> getNotificacoesUsuario(Long userId, int pagina) {
		Object[] arrayParams = new Object[] { userId, pagina, Paginacao.TAMANHO_PAGINA };
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(NotificacaoDaoContrato.BUSCAR_NOTIFICACOES, arrayParams);
		for(Map<String, Object> row: rows) {
			notificacoes.add(notificacaoRegra.buildNotificacao(row));
		}
		return notificacoes;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setChatSocketController(ChatSocketController chatSocketController) {
		this.chatSocketController = chatSocketController;
	}

	@Autowired
	public
	void setNotificacaoRegra(NotificacaoRegra notificacaoRegra) {
		this.notificacaoRegra = notificacaoRegra;
	}

}

package carros.dao.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NotificacaoDaoImpl implements NotificacaoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void criarNotificacao(Long idDestinatario, String titulo, String corpo) {
		Object[] paramsList = new Object[] {idDestinatario, titulo, corpo};
		jdbcTemplate.update(NotificacaoDaoContrato.INSERIR_NOTIFICACAO, paramsList);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

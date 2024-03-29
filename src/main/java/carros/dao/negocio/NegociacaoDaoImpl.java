package carros.dao.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.Lojista;

@Repository
public class NegociacaoDaoImpl implements NegociacaoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void comecarNegociacao(Negociacao negociacao, Lojista lojista, Chat chat) {
		Object[] paramsArray = new Object[] { negociacao.getOferta().getId(), lojista.getIdLojista(), chat.getId(),
				negociacao.getPrecoOferecido() };

		jdbcTemplate.update(NegociacaoDaoContrato.INSERT_NEGOCIACAO, paramsArray);
	}

	@Override
	public void finalizarOferta(Negociacao negociacao, Oferta oferta, Lojista lojista) {
		Object[] paramsArray = new Object[] { negociacao.getOferta().getId(), lojista.getIdLojista(),
				negociacao.getPrecoOferecido() };

		jdbcTemplate.update(NegociacaoDaoContrato.INSERT_NEGOCIACAO_JA_FINALIZADA, paramsArray);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

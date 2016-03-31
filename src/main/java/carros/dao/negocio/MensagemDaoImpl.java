package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.comunicacao.Mensagem;
import carros.regras.comunicacao.MensagemRegra;

@Repository
public class MensagemDaoImpl implements MensagemDao {

	private JdbcTemplate jdbcTemplate;
	private MensagemRegra mensagemRegra;

	@Override
	public Mensagem cadastrarMensagem(Mensagem mensagem) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(MensagemDaoContrato.INSERIR_MENSAGEM,
						new String[] { "id" });
				stmt.setString(1, mensagem.getMensagem());
				stmt.setLong(2, mensagem.getUsuario().getIdUsuario());
				stmt.setLong(3, mensagem.getChat().getId());
				stmt.setString(4, mensagem.getNomeRemetente());
				stmt.setLong(5, mensagem.getImagem().getId());

				return stmt;
			}
		}, keyHolder);

		mensagem.setId((Long) keyHolder.getKey());
		mensagem.setDataEnvio(new GregorianCalendar());
		return mensagem;
	}

	@Override
	public List<Mensagem> buscarMensagensChat(Long id) {
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Object[] arrayParams = new Object[] { id };
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(MensagemDaoContrato.GET_MENSAGENS_CHAT, arrayParams);

		for (Map<String, Object> row : rows) {
			mensagens.add(mensagemRegra.buildMensagem(row));
		}
		return mensagens;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setMensagemRegra(MensagemRegra mensagemRegra) {
		this.mensagemRegra = mensagemRegra;
	}

}

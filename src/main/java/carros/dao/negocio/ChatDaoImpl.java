package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.comunicacao.Chat;

@Repository
public class ChatDaoImpl implements ChatDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public Chat criarChat(Chat chat) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(ChatDaoContrato.INSERIR_CHAT,
						new String[] { "id" });

				stmt.setString(1, chat.getNomeDoChat());
				stmt.setLong(2, chat.getLojista().getIdLojista());
				return stmt;
			}
		}, keyHolder);

		chat.setId((Long) keyHolder.getKey());
		return chat;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

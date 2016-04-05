package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.negocio.extractor.ChatRowMapper;
import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.regras.comunicacao.ChatRegra;
import carros.regras.pessoa.UsuarioConcessionariaRegra;

@Repository
public class ChatDaoImpl implements ChatDao {

	private JdbcTemplate jdbcTemplate;
	private UsuarioConcessionariaRegra usuarioConcessionariaRegra;
	private ChatRegra chatRegra;
	private ChatRowMapper chatRowMapper;

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

	@Override
	public List<UsuarioConcessionaria> getUsuariosConcessionariaChat(Long id) {
		List<UsuarioConcessionaria> usuarios = new ArrayList<UsuarioConcessionaria>();
		Object[] listArray = new Object[] { id };
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(ChatDaoContrato.BUSCAR_USUARIOS_CHAT, listArray);
		for (Map<String, Object> row : rows) {
			usuarios.add(usuarioConcessionariaRegra.buildUsuarioConcessionaria(row));
		}
		return usuarios;
	}

	@Override
	public void InserirUsuariosConcessionaria(List<UsuarioConcessionaria> usuarios, Long idChat) {
		for (UsuarioConcessionaria usuario : usuarios) {
			Object[] arrayParams = new Object[] { idChat, usuario.getIdUsuarioConcessionaria() };

			jdbcTemplate.update(ChatDaoContrato.INSERIR_USUARIO_CHAT, arrayParams);
		}
	}

	@Override
	public List<Chat> getChatsLojista(Long idLojista) {
		List<Chat> chats = new ArrayList<Chat>();
		Object[] arrayParams = new Object[] { idLojista };
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(ChatDaoContrato.GET_TODOS_CHATS_LOJISTA,
				arrayParams);
		for (Map<String, Object> row : rows) {
			chats.add(chatRegra.buildRegra(row));
		}
		return chats;
	}

	@Override
	public List<Chat> getChatsUsuarioConcessionaria(Long idUsuarioConcessionaria) {
		List<Chat> chats = new ArrayList<Chat>();
		Object[] arrayParams = new Object[] { idUsuarioConcessionaria };
		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList(ChatDaoContrato.GET_TODOS_CHATS_USUARIO_CONCESSIONARIA, arrayParams);
		for (Map<String, Object> row : rows) {
			chats.add(chatRegra.buildRegra(row));
		}
		return chats;
	}

	@Override
	public Chat buscarChat(Chat chat) {
		Object[] arrayParams = new Object[] { chat.getId() };
		return (Chat) jdbcTemplate.queryForObject(ChatDaoContrato.BUSCAR_CHAT_POR_ID, arrayParams, chatRowMapper);
	}

	@Override
	public int finalizarCat(Chat chat) {
		Object[] arrayParams = new Object[] { chat.getId() };
		return jdbcTemplate.update(ChatDaoContrato.FINALIZAR_CHAT, arrayParams);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setUsuarioConcessionariaRegra(UsuarioConcessionariaRegra usuarioConcessionariaRegra) {
		this.usuarioConcessionariaRegra = usuarioConcessionariaRegra;
	}

	@Autowired
	public void setChatRegra(ChatRegra chatRegra) {
		this.chatRegra = chatRegra;
	}

	@Autowired
	public void setChatRowMapper(ChatRowMapper chatRowMapper) {
		this.chatRowMapper = chatRowMapper;
	}

}

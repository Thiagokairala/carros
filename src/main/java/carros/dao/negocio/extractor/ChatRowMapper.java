package carros.dao.negocio.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import carros.entities.comunicacao.Chat;
import carros.regras.comunicacao.ChatRegra;

@Component
public class ChatRowMapper implements RowMapper<Chat> {

	private ChatRegra chatRegra;

	@Override
	public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {

		return chatRegra.buildRegra(rs);
	}

	@Autowired
	public void setChatRegra(ChatRegra chatRegra) {
		this.chatRegra = chatRegra;
	}

}

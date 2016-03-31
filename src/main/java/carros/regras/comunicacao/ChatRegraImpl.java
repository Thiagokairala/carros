package carros.regras.comunicacao;

import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.comunicacao.Chat;
import carros.regras.CarrosRegras;

@Component
public class ChatRegraImpl extends CarrosRegras implements ChatRegra {

	@Override
	public Chat buildRegra(Map<String, Object> row) {
		Chat chat = new Chat();
		chat.setId(getLong(row, "idchat"));
		chat.setNomeDoChat(getString(row, "txt_nome"));
		return chat;
	}

}
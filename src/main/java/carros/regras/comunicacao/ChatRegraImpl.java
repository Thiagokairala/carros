package carros.regras.comunicacao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.Mensagem;
import carros.regras.CarrosRegras;
import carros.regras.pessoa.LojistaRegra;

@Component
public class ChatRegraImpl extends CarrosRegras implements ChatRegra {
	private LojistaRegra lojistaRegra;

	@Override
	public Chat buildRegra(Map<String, Object> row) {
		Chat chat = new Chat();
		chat.setId(getLong(row, "idchat"));
		chat.setNomeDoChat(getString(row, "txt_nome"));
		chat.setLojista(lojistaRegra.buildLojista(row));
		chat.setMensagens(new ArrayList<Mensagem>());
		return chat;
	}

	@Override
	public Chat buildRegra(ResultSet rs) {
		Chat chat = new Chat();
		chat.setId(getLong(rs, "idchat"));
		chat.setNomeDoChat(getString(rs, "txt_nome"));
		chat.setLojista(lojistaRegra.buildLojista(rs));
		chat.setMensagens(new ArrayList<Mensagem>());
		return chat;
	}

	@Autowired
	public void setLojistaRegra(LojistaRegra lojistaRegra) {
		this.lojistaRegra = lojistaRegra;
	}

}

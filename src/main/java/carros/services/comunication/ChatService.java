package carros.services.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.ChatDao;
import carros.dao.pessoa.LojistaDao;
import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.Lojista;

@Service
public class ChatService {
	private LojistaDao lojistaDao;
	private ChatDao chatDao;

	public List<Chat> getChatsLojista(Long sessionUserId) {
		Lojista lojista = lojistaDao.buscarLojistaPorIdUsuario(sessionUserId);
		return chatDao.getChatsLojista(lojista.getIdLojista());
	}

	public List<Chat> geChatsUsuarioConcessionaria(Long sessionUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}

	@Autowired
	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

}

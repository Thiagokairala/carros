package carros.services.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.ChatDao;
import carros.dao.negocio.MensagemDao;
import carros.dao.pessoa.LojistaDao;
import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.Mensagem;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.UsuarioConcessionaria;

@Service
public class ChatService {
	private LojistaDao lojistaDao;
	private ChatDao chatDao;
	private MensagemDao mensagemDao;
	private UsuarioConcessionariaDao usuarioConcessionariaDao;

	public List<Chat> getChatsLojista(Long sessionUserId) {
		Lojista lojista = lojistaDao.buscarLojistaPorIdUsuario(sessionUserId);
		return chatDao.getChatsLojista(lojista.getIdLojista());
	}

	public List<Chat> geChatsUsuarioConcessionaria(Long sessionUserId) {
		UsuarioConcessionaria usuarioConcessionaria = usuarioConcessionariaDao
				.buscarUsuarioConcessionariaPorIdUsuario(sessionUserId);
		return chatDao.getChatsUsuarioConcessionaria(usuarioConcessionaria.getIdUsuarioConcessionaria());
	}

	public Mensagem registrarMensagem(Mensagem mensagem) {
		mensagem = mensagemDao.cadastrarMensagem(mensagem);
		return mensagem;
	}

	public List<Mensagem> getMensagensPorChat(Long id) {
		
		return mensagemDao.buscarMensagensChat(id);
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}

	@Autowired
	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	@Autowired
	public void setMensagemDao(MensagemDao mensagemDao) {
		this.mensagemDao = mensagemDao;
	}

	@Autowired
	public void setUsuarioConcessionariaDao(UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

}

package carros.controllers.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.controllers.ControladoraBase;
import carros.entities.comunicacao.Chat;
import carros.exception.UsuarioNaoTemChatException;
import carros.security.session.UsuarioSessao;
import carros.services.comunication.ChatService;

@RestController
@Service
@RequestMapping("/chat")
@Scope("request")
public class ChatController extends ControladoraBase {

	private ChatService chatService;

	@RequestMapping(value = "/allChats", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Chat>> getAllChats() throws Exception {
		List<Chat> chats = null;
		UsuarioSessao usuarioSessao = super.getUsuarioSessaoFactory().createInstance();

		if (usuarioSessao.isLojista()) {
			chats = chatService.getChatsLojista(usuarioSessao.getSessionUserId());
		} else if (usuarioSessao.isUsuarioConcessionaria()) {
			chats = chatService.geChatsUsuarioConcessionaria(usuarioSessao.getSessionUserId());
		} else {
			throw new UsuarioNaoTemChatException();
		}

		for (Chat chat : chats) {
			chat.setMensagens(chatService.getMensagensPorChat(chat.getId()));
		}

		return new ResponseEntity<List<Chat>>(chats, HttpStatus.OK);
	}

	@Autowired
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

}

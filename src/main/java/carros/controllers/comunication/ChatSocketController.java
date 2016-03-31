package carros.controllers.comunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.UsuarioConcessionaria;

@Controller
public class ChatSocketController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	private final static String CHAT_TOPIC = "/topic/chats/";

	@MessageMapping("/chat")
	public void sendMessage(Chat chat) {
		for (UsuarioConcessionaria usuario : chat.getUsuariosConcessionaria()) {
			System.out.println("/topic/chat/" + usuario.getUsuario().getIdUsuario());
			simpMessagingTemplate.convertAndSend(CHAT_TOPIC + usuario.getUsuario().getIdUsuario(), chat.getId());
		}
		simpMessagingTemplate.convertAndSend(CHAT_TOPIC + chat.getLojista().getUsuario().getIdUsuario(), chat.getId());
	}

}

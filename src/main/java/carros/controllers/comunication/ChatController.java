package carros.controllers.comunication;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.Mensagem;

@Controller
public class ChatController {
	
	@MessageMapping("/chat")
    @SendTo("/topic/teste")
	public void sendMessage(Mensagem mensagem) {
		System.out.println("entrou");
		Chat chat = new Chat();
		chat.setId(1231L);

	}
}

package carros.controllers.comunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.Mensagem;
import carros.entities.comunicacao.Notificacao;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.services.comunication.ChatService;

@Controller
public class ChatSocketController {

	private SimpMessagingTemplate simpMessagingTemplate;
	private ChatService chatService;

	private final static String CHAT_TOPIC = "/topic/chats/";
	private final static String MENSAGENS_TOPIC = "/topic/mensagem/";
	private final static String FINALIZAR_CHAT_TOPIC = "/topic/finalizaChat/";
	private final static String NOTIFICACOES = "/topic/notificacao/";

	@MessageMapping("/notificacao")
	public void sendNotificacao(Long destinatario, String titulo, String texto) {
		Notificacao notificacao = new Notificacao();
		notificacao.setTitulo(titulo);
		notificacao.setCorpo(texto);
		System.out.println("Enviando para " + destinatario);
		simpMessagingTemplate.convertAndSend(NOTIFICACOES + destinatario, notificacao);
	}

	@MessageMapping("/chat")
	public void sendMessage(Chat chat) {
		for (UsuarioConcessionaria usuario : chat.getUsuariosConcessionaria()) {
			simpMessagingTemplate.convertAndSend(CHAT_TOPIC + usuario.getUsuario().getIdUsuario(), chat.getId());
		}
		simpMessagingTemplate.convertAndSend(CHAT_TOPIC + chat.getLojista().getUsuario().getIdUsuario(), chat.getId());
	}

	@MessageMapping("/newMessage")
	public void sendMessageOfChat(Mensagem mensagem) {
		mensagem = chatService.registrarMensagem(mensagem);
		Chat chat = chatService.buscarChatComIntegrantes(mensagem.getChat());
		for (UsuarioConcessionaria usuario : chat.getUsuariosConcessionaria()) {
			simpMessagingTemplate.convertAndSend(MENSAGENS_TOPIC + usuario.getUsuario().getIdUsuario(), mensagem);
		}
		simpMessagingTemplate.convertAndSend(MENSAGENS_TOPIC + chat.getLojista().getUsuario().getIdUsuario(), mensagem);
	}

	@MessageMapping("/finalizarChat")
	public void finalizarChat(Chat chat) {
		try {
			chat = chatService.buscarChatComIntegrantes(chat);
			for (UsuarioConcessionaria usuario : chat.getUsuariosConcessionaria()) {
				simpMessagingTemplate.convertAndSend(FINALIZAR_CHAT_TOPIC + usuario.getUsuario().getIdUsuario(),
						chat.getId());
			}
			simpMessagingTemplate.convertAndSend(FINALIZAR_CHAT_TOPIC + chat.getLojista().getUsuario().getIdUsuario(),
					chat.getId());
		} catch (Exception e) {
			// nothing to do.
		}

	}

	@Autowired
	public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@Autowired
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

}

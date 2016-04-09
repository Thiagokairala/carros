package carros.controllers.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.controllers.ControladoraBase;
import carros.controllers.comunication.ChatSocketController;
import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.NovaOfertaDto;
import carros.entities.usuarios.Lojista;
import carros.services.comunication.ChatService;
import carros.services.negocio.NegociacaoService;

@RestController
@Service
@RequestMapping("/negociacao")
@Scope("request")
public class NegociacaoController extends ControladoraBase {

	private NegociacaoService negociacaoService;
	private ChatSocketController chatSocketController;
	private ChatService chatService;

	@RequestMapping(value = "/comecar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Chat> comecarNegociacao(@RequestBody Negociacao negociacao) throws Exception {
		Lojista lojista = super.usuarioSessaoEhLojista();
		System.out.println(negociacao);
		Chat chat = negociacaoService.abrirNegociacoes(negociacao, lojista);
		if (chat == null) {
			List<Chat> chats = chatService.finalizarChats(negociacao.getOferta());
			for(Chat chatParaFInalizar : chats) {
				chatSocketController.finalizarChat(chatParaFInalizar);
			}
			return new ResponseEntity<Chat>(HttpStatus.ACCEPTED);
		} else {
			chatSocketController.sendMessage(chat);
			return new ResponseEntity<Chat>(chat, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/novaOferta", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> novaOferta(@RequestBody NovaOfertaDto novaOfertaDto) {
		negociacaoService.novaOferta(novaOfertaDto);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Autowired
	public void setNegociacaoService(NegociacaoService negociacaoService) {
		this.negociacaoService = negociacaoService;
	}

	@Autowired
	public void setChatSocketCOntroller(ChatSocketController chatSocketController) {
		this.chatSocketController = chatSocketController;
	}

	@Autowired
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

}

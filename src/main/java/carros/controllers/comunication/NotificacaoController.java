package carros.controllers.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.comunicacao.Notificacao;
import carros.services.comunicationo.NotificacaoService;

@RestController
@Service
@RequestMapping("/notificacao")
@Scope("request")
public class NotificacaoController {

	private NotificacaoService notificacaoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Notificacao>> listar(@RequestParam Long userId,
			@RequestParam(required = false, defaultValue = "0") int pagina) {
		return new ResponseEntity<List<Notificacao>>(notificacaoService.getNotificacoes(userId, pagina), HttpStatus.OK);
	}

	@Autowired
	public void setNotificacaoService(NotificacaoService notificacaoService) {
		this.notificacaoService = notificacaoService;
	}

}

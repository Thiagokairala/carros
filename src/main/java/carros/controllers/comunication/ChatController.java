package carros.controllers.comunication;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.comunicacao.Chat;

@RestController
@Service
@RequestMapping("/chat")
@Scope("reqest")
public class ChatController {

	@RequestMapping(value = "/allChats", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Chat>> getAllChats() {
		return new ResponseEntity<List<Chat>>(HttpStatus.OK);
	}
}

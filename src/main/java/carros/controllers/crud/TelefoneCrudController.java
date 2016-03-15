package carros.controllers.crud;

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

import carros.entities.residenciais.Telefone;
import carros.services.crud.TelefoneCrudService;

@RestController
@RequestMapping("/telefone")
@Service
@Scope("request")
public class TelefoneCrudController {
	private TelefoneCrudService telefoneCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Telefone> inserirTelefone(
			@RequestBody Telefone telefone) {

		return new ResponseEntity<Telefone>(
				telefoneCrudService.inserirTelefone(telefone), HttpStatus.OK);
	}

	@Autowired
	public void setTelefoneCrudService(TelefoneCrudService telefoneCrudService) {
		this.telefoneCrudService = telefoneCrudService;
	}

}

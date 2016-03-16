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

import carros.entities.usuarios.UsuarioConcessionaria;
import carros.services.crud.UsuarioConcessionariaCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/usuarioConcessionaria")
public class UsuarioConcessionariaCrudController {

	private UsuarioConcessionariaCrudService usuarioConcessionariaCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UsuarioConcessionaria> inserirUsuarioConcessionaria(
			@RequestBody UsuarioConcessionaria usuarioConcessionaria) {
		return new ResponseEntity<UsuarioConcessionaria>(
				usuarioConcessionariaCrudService
						.inserirUsuarioConcessionaria(usuarioConcessionaria),
				HttpStatus.OK);
	}

	@Autowired
	public void setUsuarioConcessionariaCrudService(
			UsuarioConcessionariaCrudService usuarioConcessionariaCrudService) {
		this.usuarioConcessionariaCrudService = usuarioConcessionariaCrudService;
	}

}

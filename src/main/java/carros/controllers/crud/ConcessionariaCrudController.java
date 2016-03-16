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

import carros.entities.usuarios.Concessionaria;
import carros.services.crud.ConcessionariaCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/concessionaria")
public class ConcessionariaCrudController {

	private ConcessionariaCrudService concessionariaCrudService;

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Concessionaria> inserirConcessionaria(
			@RequestBody Concessionaria concessionaria) {

		return new ResponseEntity<Concessionaria>(
				concessionariaCrudService.inserirConcessionaria(concessionaria),
				HttpStatus.OK);
	}

	@Autowired
	public void setConcessionariaCrudService(
			ConcessionariaCrudService concessionariaCrudService) {
		this.concessionariaCrudService = concessionariaCrudService;
	}

}

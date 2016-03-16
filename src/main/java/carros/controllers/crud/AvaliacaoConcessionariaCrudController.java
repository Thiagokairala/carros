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

import carros.entities.negocio.AvaliacaoConcessionaria;
import carros.services.crud.AvaliacaoConcessionariaCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/avaliacaoConcessionaria")
public class AvaliacaoConcessionariaCrudController {
	private AvaliacaoConcessionariaCrudService avaliacaoConcessionariaCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<AvaliacaoConcessionaria> avaliarConcessionaria(
			@RequestBody AvaliacaoConcessionaria avaliacaoConcessionaria) {
		return new ResponseEntity<AvaliacaoConcessionaria>(
				avaliacaoConcessionariaCrudService
						.avaliarConcessionaria(avaliacaoConcessionaria),
				HttpStatus.OK);
	}

	@Autowired
	public void setAvaliacaoConcessionariaCrudService(
			AvaliacaoConcessionariaCrudService avaliacaoConcessionariaCrudService) {
		this.avaliacaoConcessionariaCrudService = avaliacaoConcessionariaCrudService;
	}

}

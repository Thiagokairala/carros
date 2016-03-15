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

import carros.entities.negocio.AvaliacaoVeiculo;
import carros.services.crud.AvaliacaoVeiculoCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/avaliacaoVeiculo")
public class AvaliacaoVeiculoCrudController {

	private AvaliacaoVeiculoCrudService avaliacaoVeiculoCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<AvaliacaoVeiculo> inserirAvaliacaoVeiculo(
			@RequestBody AvaliacaoVeiculo avaliacaoVeiculo) {

		return new ResponseEntity<AvaliacaoVeiculo>(
				avaliacaoVeiculoCrudService
						.inserirAvaliacaoVeiculo(avaliacaoVeiculo),
				HttpStatus.OK);
	}

	@Autowired
	public void setAvaliacaoVeiculoCrudService(
			AvaliacaoVeiculoCrudService avaliacaoVeiculoCrudService) {
		this.avaliacaoVeiculoCrudService = avaliacaoVeiculoCrudService;
	}

}

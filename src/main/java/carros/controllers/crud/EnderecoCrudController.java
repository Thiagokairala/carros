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

import carros.entities.residenciais.Endereco;
import carros.services.crud.EnderecoCrudService;

@RestController
@RequestMapping("/endereco")
@Service
@Scope("request")
public class EnderecoCrudController {

	private EnderecoCrudService enderecoCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Endereco> cadastrarEndereco(
			@RequestBody Endereco endereco) {

		return new ResponseEntity<Endereco>(
				enderecoCrudService.cadastrarEndereco(endereco), HttpStatus.OK);
	}

	@Autowired
	public void setEnderecoCrudService(EnderecoCrudService enderecoCrudService) {
		this.enderecoCrudService = enderecoCrudService;
	}

}

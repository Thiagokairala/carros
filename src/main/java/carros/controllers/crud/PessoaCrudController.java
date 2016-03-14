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

import carros.entities.pessoas.Pessoa;
import carros.services.crud.PessoaCrudService;

@RestController
@RequestMapping("/pessoa")
@Service
@Scope("request")
public class PessoaCrudController {

	private PessoaCrudService pessoaCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> inserirPessoa(
			@RequestBody Pessoa pessoa) {
		System.out.println(pessoa);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Autowired
	public void setPessoaCrudServic(PessoaCrudService pessoaCrudService) {
		this.pessoaCrudService = pessoaCrudService;
	}
}

package carros.controllers.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.negocio.Acessorio;
import carros.services.negocio.AcessoriosService;

@RestController
@RequestMapping("/acessorios")
@Scope("request")
@Service
public class AcessoriosController {

	private AcessoriosService acessoriosService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Acessorio>> listarAcessorios() {
		return new ResponseEntity<List<Acessorio>>(acessoriosService.getAcessorios(), HttpStatus.OK);
	}

	@Autowired
	public void setAcessoriosService(AcessoriosService acessoriosService) {
		this.acessoriosService = acessoriosService;
	}

}

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

import carros.entities.negocio.CorVeiculo;
import carros.services.crud.CorVeiculoService;

@RestController
@Service
@RequestMapping("/cor")
@Scope("request")
public class CorController {

	private CorVeiculoService corVeiculoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<CorVeiculo>> listarCor() {
		return new ResponseEntity<List<CorVeiculo>>(corVeiculoService.listaCores(), HttpStatus.OK);
	}

	@Autowired
	public void setCorVeiculoService(CorVeiculoService corVeiculoService) {
		this.corVeiculoService = corVeiculoService;
	}

}

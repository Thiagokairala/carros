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

import carros.entities.negocio.ModeloVeiculo;
import carros.services.crud.ModeloVeiculoService;

@RequestMapping("/modelo")
@RestController
@Service
@Scope("request")
public class ModeloVeiculoController {

	private ModeloVeiculoService modeloVeiculoService;

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> registrarModelo(@RequestBody ModeloVeiculo modeloVeiculo) {
		return new ResponseEntity<String>(modeloVeiculoService.registrar(modeloVeiculo), HttpStatus.OK);
	}

	@Autowired
	public void setModeloVeiculoService(ModeloVeiculoService modeloVeiculoService) {
		this.modeloVeiculoService = modeloVeiculoService;
	}

}

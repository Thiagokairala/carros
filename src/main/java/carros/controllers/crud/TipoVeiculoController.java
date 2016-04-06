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

import carros.entities.negocio.TipoVeiculo;
import carros.services.crud.TipoVeiculoService;

@RestController
@Service
@RequestMapping("/tipoVeiculo")
@Scope("request")
public class TipoVeiculoController {

	private TipoVeiculoService tipoViculoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<TipoVeiculo>> listarTiposVeiculos() {
		return new ResponseEntity<List<TipoVeiculo>>(tipoViculoService.listarTiposVeiculo(), HttpStatus.OK);
	}

	@Autowired
	public void setTipoViculoService(TipoVeiculoService tipoViculoService) {
		this.tipoViculoService = tipoViculoService;
	}

}

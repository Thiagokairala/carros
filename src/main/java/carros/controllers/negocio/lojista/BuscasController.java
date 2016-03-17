package carros.controllers.negocio.lojista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.negocio.Veiculo;
import carros.services.negocio.lojista.BuscasService;

@RestController
@Service
@Scope("request")
@RequestMapping("/buscas")
public class BuscasController {

	private BuscasService buscasService;

	public @ResponseBody ResponseEntity<List<Veiculo>> listarTodosVeiculos() {
		return new ResponseEntity<List<Veiculo>>(
				buscasService.listarTodasOfertas(), HttpStatus.OK);
	}

	@Autowired
	public void setBuscasService(BuscasService buscasService) {
		this.buscasService = buscasService;
	}
}

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

import carros.entities.usuarios.Lojista;
import carros.services.crud.LojistaCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/lojista")
public class LojistaCrudController {
	private LojistaCrudService lojistaCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Lojista> inserirLojista(
			@RequestBody Lojista lojista) throws Exception {
		return new ResponseEntity<Lojista>(
				lojistaCrudService.inserirLojista(lojista), HttpStatus.OK);
	}

	@Autowired
	public void setLojistaCrudService(LojistaCrudService lojistaCrudService) {
		this.lojistaCrudService = lojistaCrudService;
	}

}

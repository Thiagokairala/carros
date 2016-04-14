package carros.controllers.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.usuarios.Concessionaria;
import carros.services.crud.ConcessionariaCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/concessionaria")
public class ConcessionariaCrudController {

	private ConcessionariaCrudService concessionariaCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Concessionaria> inserirConcessionaria(
			@RequestBody Concessionaria concessionaria) throws Exception {

		return new ResponseEntity<Concessionaria>(concessionariaCrudService.inserirConcessionaria(concessionaria),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Concessionaria> updateConcessionaria(@RequestBody Concessionaria concessionaria) {
		concessionariaCrudService.updateConcessionaria(concessionaria);
		return new ResponseEntity<Concessionaria>(HttpStatus.OK);
	}

	@RequestMapping(value = "/buscarTodas", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Concessionaria>> buscarTodasConcessionarias() {
		return new ResponseEntity<List<Concessionaria>>(concessionariaCrudService.buscarTodasConcessionarias(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/buscarPorId", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Concessionaria> buscarConcessionariaPorId(@RequestParam long id) {
		return new ResponseEntity<Concessionaria>(concessionariaCrudService.buscarConcessionariaPorId(id),
				HttpStatus.OK);
	}

	@Autowired
	public void setConcessionariaCrudService(ConcessionariaCrudService concessionariaCrudService) {
		this.concessionariaCrudService = concessionariaCrudService;
	}

}

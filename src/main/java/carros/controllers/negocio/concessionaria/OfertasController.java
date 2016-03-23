package carros.controllers.negocio.concessionaria;

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

import carros.controllers.ControladoraBase;
import carros.entities.negocio.MarcaVeiculo;
import carros.entities.negocio.ModeloVeiculo;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.services.negocio.concessionaria.OfertaService;

@RestController
@Scope("request")
@RequestMapping("/ofertas")
@Service
public class OfertasController extends ControladoraBase {

	private OfertaService ofertaService;

	@RequestMapping(value = "/todasMarcas", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<MarcaVeiculo>> todasMarcas() {
		return new ResponseEntity<List<MarcaVeiculo>>(ofertaService.getTodasMarcas(), HttpStatus.OK);
	}

	@RequestMapping(value = "/modelosPorMarca", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ModeloVeiculo>> modelosPorMarca(
			@RequestParam(required = true, name = "marca") int idMarca) {
		return new ResponseEntity<List<ModeloVeiculo>>(ofertaService.getModelosPorMarca(idMarca), HttpStatus.OK);
	}

	@RequestMapping(value = "/cadastrarOferta", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Oferta> cadastrarOferta(@RequestBody Oferta oferta) throws Exception {
		UsuarioConcessionaria usuarioConcessionaria = super.usuarioSessaoEhUsuarioConcessionaria();
		oferta.setConcessionaria(usuarioConcessionaria.getConcessionaria());
		return new ResponseEntity<Oferta>(ofertaService.cadastrarOferta(oferta), HttpStatus.OK);
	}

	@RequestMapping(value = "/todasOfertas", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> todasOfertas() {
		return new ResponseEntity<List<Oferta>>(HttpStatus.OK);
	}

	@Autowired
	public void setOfertaService(OfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}
}

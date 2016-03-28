package carros.controllers.negocio.lojista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.dao.negocio.OfertaDao;
import carros.entities.negocio.Oferta;
import carros.services.negocio.lojista.BuscasService;

@RestController
@Service
@Scope("request")
@RequestMapping("/buscas")
public class BuscasController {

	private BuscasService buscasService;
	private OfertaDao ofertaDao;

	@RequestMapping(value = "/todasOfertas", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> listarTodosVeiculos(
			@RequestParam(required = false, defaultValue = "0") int pagina) {
		return new ResponseEntity<List<Oferta>>(buscasService.listarTodasOfertas(pagina), HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasTipoVeiculo", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> listarVeiculosPorTipo(
			@RequestParam(required = true) int idTipoVeiculo,
			@RequestParam(required = false, defaultValue = "0") int pagina) {
		return new ResponseEntity<List<Oferta>>(buscasService.listarOfertasTipoVeiculo(idTipoVeiculo, pagina),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasMarca", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> listarVeiculosPorMarca(@RequestParam(required = true) int idMarca,
			@RequestParam(required = false, defaultValue = "0") int pagina) {
		return new ResponseEntity<List<Oferta>>(buscasService.listarOfertasMarca(idMarca, pagina), HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasPorRangeDePreco", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> listarOfertasPorRangeDePreco(
			@RequestParam(required = true) double precoMaximo,
			@RequestParam(required = false, defaultValue = "0") double precoMinimo,
			@RequestParam(required = false, defaultValue = "0") int pagina) {
		return new ResponseEntity<List<Oferta>>(
				buscasService.listarOfertaPorRangeDePreco(precoMinimo, precoMaximo, pagina), HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasPorFiltro", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> listarOfertasPorFiltro(
			@RequestParam(required = true) String filtro,
			@RequestParam(required = false, defaultValue = "0") int pagina) throws Exception {
		return new ResponseEntity<List<Oferta>>(buscasService.listarOfertaPorFiltro(filtro, pagina), HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasPorId", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Oferta> buscarOfertaPorId(@RequestParam(defaultValue = "0") long ifOferta) {
		Oferta oferta = new Oferta();
		oferta.setId(ifOferta);
		return new ResponseEntity<Oferta>(ofertaDao.buscarOfertaPorId(oferta), HttpStatus.OK);
	}

	@RequestMapping(value = "/ofertasPorConcessionaria", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Oferta>> ofertasPorConcessionaria(
			@RequestParam(required = true) long idConcessionaria) {
		return new ResponseEntity<List<Oferta>>(buscasService.getOfertasConcessionaria(idConcessionaria),
				HttpStatus.OK);
	}

	@Autowired
	public void setBuscasService(BuscasService buscasService) {
		this.buscasService = buscasService;
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}

}

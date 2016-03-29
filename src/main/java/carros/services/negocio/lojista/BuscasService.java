package carros.services.negocio.lojista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.OfertaDao;
import carros.entities.negocio.Oferta;
import carros.services.image.ImagemService;
import carros.services.negocio.AcessoriosService;
import carros.util.Paginacao;

@Service
public class BuscasService {

	private OfertaDao ofertaDao;
	private ImagemService imagemService;
	private AcessoriosService acessoriosService;

	public List<Oferta> listarTodasOfertas(int page) {
		page *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarTodasOfertas(page);
	}

	public List<Oferta> listarOfertasTipoVeiculo(int idTipoVeiculo, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasTipoVeiculo(idTipoVeiculo, pagina);
	}

	public List<Oferta> listarOfertasMarca(int idMarca, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasMarca(idMarca, pagina);
	}

	public List<Oferta> listarOfertaPorRangeDePreco(double precoMinimo, double precoMaximo, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasPorRangeDePreco(precoMinimo, precoMaximo, pagina);
	}

	public List<Oferta> getOfertasConcessionaria(long idConcessionaria) {
		return ofertaDao.buscarOfertasPorConcessionaria(idConcessionaria);
	}

	public List<Oferta> listarOfertaPorFiltro(String filtro, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasPorFiltro(filtro, pagina);
	}

	public Oferta buscarOfertaPorId(long idOferta) {
		Oferta oferta = new Oferta();
		oferta.setId(idOferta);
		oferta = ofertaDao.buscarOfertaPorId(oferta);
		oferta.getVeiculo().getAvaliacaoVeiculo().setImages(imagemService.getImagemOferta(oferta));
		oferta.getVeiculo().setAcessorios(acessoriosService.getAcessorios(oferta.getVeiculo().getId()));
		return oferta;
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}

	@Autowired
	public void setImagemService(ImagemService imagemService) {
		this.imagemService = imagemService;
	}

	@Autowired
	public void setAcessoriosService(AcessoriosService acessoriosService) {
		this.acessoriosService = acessoriosService;
	}

}

package carros.services.negocio.lojista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.OfertaDao;
import carros.entities.negocio.Oferta;
import carros.util.Paginacao;

@Service
public class BuscasService {

	private OfertaDao ofertaDao;

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

	public List<Oferta> listarOfertaPorRangeDePreco(double precoMinimo,
			double precoMaximo, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasPorRangeDePreco(precoMinimo, precoMaximo,
				pagina);
	}

	public List<Oferta> listarOfertaPorFiltro(String filtro, int pagina) {
		pagina *= Paginacao.TAMANHO_PAGINA;
		return ofertaDao.buscarOfertasPorFiltro(filtro, pagina);
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}

}

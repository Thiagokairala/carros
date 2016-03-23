package carros.dao.negocio;

import java.util.List;

import carros.entities.negocio.Oferta;

public interface OfertaDao {
	public List<Oferta> buscarTodasOfertas(int page);

	public List<Oferta> buscarOfertasTipoVeiculo(int idTipoVeiculo, int pagina);

	public List<Oferta> buscarOfertasMarca(int idMarca, int pagina);

	public List<Oferta> buscarOfertasPorRangeDePreco(double precoMinimo,
			double precoMaximo, int pagina);

	public List<Oferta> buscarOfertasPorFiltro(String filtro, int pagina);

	public Oferta inserirOferta(Oferta oferta);
}

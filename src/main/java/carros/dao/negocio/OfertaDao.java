package carros.dao.negocio;

import java.util.GregorianCalendar;
import java.util.List;

import carros.entities.comunicacao.NovaOfertaDto;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.Lojista;

public interface OfertaDao {
	public List<Oferta> buscarTodasOfertas(int page);

	public List<Oferta> buscarOfertasTipoVeiculo(int idTipoVeiculo, int pagina);

	public List<Oferta> buscarOfertasMarca(int idMarca, int pagina);

	public List<Oferta> buscarOfertasPorRangeDePreco(double precoMinimo, double precoMaximo, int pagina);

	public List<Oferta> buscarOfertasPorFiltro(String filtro, int pagina);

	public Oferta inserirOferta(Oferta oferta);

	public Oferta buscarOfertaPorId(Oferta oferta);

	public void finalizarOferta(Oferta oferta, Lojista lojista);

	public List<Oferta> buscarOfertasPorConcessionaria(long idConcessionaria);

	public Oferta buscarOfertaPorChat(NovaOfertaDto novaOfertaDto);

	public Boolean lojistaJaFezOferta(Long ofertaId, Long lojistaId);

	public Integer countOfertasFechadas(Long id, GregorianCalendar inicio, GregorianCalendar fim);

	public void incluirImagemOferta(Long id, Long id2);

	public List<Oferta> buscarOfertasNaoAvaliadas(Long idLojista);

	public void setOfertaAvaliada(Long id);
}

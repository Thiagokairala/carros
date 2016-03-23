package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.Oferta;
import carros.regras.negocio.OfertaRule;
import carros.util.Paginacao;

@Repository
public class OfertaDaoImpl implements OfertaDao {

	private OfertaRule ofertaRule;

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Oferta> buscarTodasOfertas(int page) {
		Object[] arrayParams = new Object[] { page, Paginacao.TAMANHO_PAGINA };
		return this.buscarOfertasPrivate(OfertaDaoContrato.SELECT_TODAS_OFERTAS, arrayParams);

	}

	@Override
	public List<Oferta> buscarOfertasTipoVeiculo(int idTipoVeiculo, int pagina) {
		Object[] arrayParams = new Object[] { idTipoVeiculo, pagina, Paginacao.TAMANHO_PAGINA };
		return this.buscarOfertasPrivate(OfertaDaoContrato.SELECT_OFERTAS_POR_TIPO, arrayParams);
	}

	@Override
	public List<Oferta> buscarOfertasMarca(int idMarca, int pagina) {
		Object[] arrayParams = new Object[] { idMarca, pagina, Paginacao.TAMANHO_PAGINA };

		return this.buscarOfertasPrivate(OfertaDaoContrato.SELECT_OFERTAS_POR_MARCA, arrayParams);
	}

	@Override
	public List<Oferta> buscarOfertasPorRangeDePreco(double precoMinimo, double precoMaximo, int pagina) {
		Object[] arrayParams = new Object[] { precoMinimo, precoMaximo, pagina, Paginacao.TAMANHO_PAGINA };

		return this.buscarOfertasPrivate(OfertaDaoContrato.SELECT_OFERTAS_POR_RANGE_DE_PRECO, arrayParams);
	}

	@Override
	public List<Oferta> buscarOfertasPorFiltro(String filtro, int pagina) {
		Object[] arrayParams = new Object[] { filtro, filtro, pagina, Paginacao.TAMANHO_PAGINA };

		return this.buscarOfertasPrivate(OfertaDaoContrato.SELECT_OFERTAS_POR_FILTRO, arrayParams);
	}

	@Override
	public Oferta inserirOferta(Oferta oferta) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection
						.prepareStatement(OfertaDaoContrato.INSERIR_OFERTA, new String[] { "id" });

				stmt.setLong(1, oferta.getConcessionaria().getIdConcessionaria());
				stmt.setLong(2, oferta.getVeiculo().getId());
				stmt.setBigDecimal(3, oferta.getValorDaOferta());
				
				return stmt;
			}
		}, keyHolder);

		oferta.setId((Long) keyHolder.getKey());
		return oferta;
	}

	private List<Oferta> buscarOfertasPrivate(String query, Object[] params) {
		List<Oferta> ofertas = new ArrayList<Oferta>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, params);
		for (Map<String, Object> row : rows) {
			ofertas.add(ofertaRule.buildOferta(row));
		}
		return ofertas;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setOfertaRule(OfertaRule ofertaRule) {
		this.ofertaRule = ofertaRule;
	}

}

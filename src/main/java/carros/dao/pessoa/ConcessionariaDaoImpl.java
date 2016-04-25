package carros.dao.pessoa;

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

import carros.dao.pessoa.extractor.ConcessionariaRowMapper;
import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.Usuario;
import carros.regras.pessoa.ConcessionariaRegra;

@Repository
public class ConcessionariaDaoImpl implements ConcessionariaDao {

	private JdbcTemplate jdbcTemplate;
	private UsuarioDao usuarioDao;
	private ConcessionariaRowMapper concessionariaRowMapper;
	private ConcessionariaRegra concessionariaRegra;

	@Override
	public void inserirNotaConcessionaria(Concessionaria concessionaria) {
		Object[] arrayArguments = new Object[] { concessionaria.getNotaGeral(), concessionaria.getNumeroAvaliacoes(),
				concessionaria.getIdConcessionaria() };

		jdbcTemplate.update(ConcessionariaDaoContrato.INSERIR_AVALIACAO_CONCESSIONARIA, arrayArguments);
	}

	@Override
	public Concessionaria inserirConcessionaria(Concessionaria concessionaria) throws Exception {
		Usuario usuario = usuarioDao.inserirUsuario(concessionaria.getUsuario());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(ConcessionariaDaoContrato.INSERIR_CONCESSIONARIA,
						new String[] { "id" });
				stmt.setLong(1, usuario.getIdUsuario());
				stmt.setString(2, concessionaria.getResponsavel());
				return stmt;
			}
		}, keyHolder);

		concessionaria.setIdConcessionaria((Long) keyHolder.getKey());

		return concessionaria;
	}

	@Override
	public Concessionaria buscarConcessionaria(Concessionaria concessionaria) {
		Object[] arrayArguments = new Object[] { concessionaria.getIdConcessionaria() };
		concessionaria = (Concessionaria) jdbcTemplate.queryForObject(ConcessionariaDaoContrato.SELECT_CONCESSIONARIA,
				arrayArguments, concessionariaRowMapper);
		return concessionaria;
	}

	@Override
	public Concessionaria buscarConcessionariaPorIdUsuario(Long idUsuario) {
		Object[] arrayArguments = new Object[] { idUsuario };
		return (Concessionaria) jdbcTemplate.queryForObject(
				ConcessionariaDaoContrato.SELECT_CONCESSIONARIA_BY_ID_USUARIO, arrayArguments, concessionariaRowMapper);
	}

	@Override
	public List<Concessionaria> buscarTodasConcessionaria() {
		List<Concessionaria> concessionarias = new ArrayList<Concessionaria>();
		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList(ConcessionariaDaoContrato.SELECT_TODAS_CONCESSIONARIO);
		for (Map<String, Object> row : rows) {
			concessionarias.add(concessionariaRegra.construirConcessionaria(row));
		}
		return concessionarias;
	}

	@Override
	public void update(Concessionaria concessionaria) {
		usuarioDao.updateUsuario(concessionaria.getUsuario());
	}

	@Autowired
	public void setConcessionariaRowMapper(ConcessionariaRowMapper concessionariaRowMapper) {
		this.concessionariaRowMapper = concessionariaRowMapper;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setConcessionariaRegra(ConcessionariaRegra concessionariaRegra) {
		this.concessionariaRegra = concessionariaRegra;
	}

}

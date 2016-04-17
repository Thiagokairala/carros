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

import carros.dao.pessoa.extractor.UsuarioConcessionariaRowMapper;
import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.NivelUsuarioConcessionaria;
import carros.entities.usuarios.Usuario;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.regras.pessoa.NivelUsuarioConcessionariaRegra;
import carros.regras.pessoa.UsuarioConcessionariaRegra;

@Repository
public class UsuarioConcessionariaDaoImpl implements UsuarioConcessionariaDao {
	private JdbcTemplate jdbcTemplate;
	private UsuarioDao usuarioDao;
	private UsuarioConcessionariaRowMapper usuarioConcessionariaRowMapper;
	private UsuarioConcessionariaRegra usuarioConcessionariaRegra;
	private NivelUsuarioConcessionariaRegra nivelUsuarioConcessionariaRegra;

	@Override
	public UsuarioConcessionaria inserirUsuarioConcessionaria(UsuarioConcessionaria usuarioConcessionaria) throws Exception {
		Usuario usuario = usuarioDao.inserirUsuario(usuarioConcessionaria.getUsuario(), true);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						UsuarioConcessionariaDaoContrato.INSERIR_USUARIO_CONCESSIONARIA, new String[] { "id" });
				stmt.setLong(1, usuarioConcessionaria.getConcessionaria().getIdConcessionaria());
				stmt.setLong(2, usuario.getIdUsuario());
				stmt.setLong(3, usuarioConcessionaria.getNivelUsuarioConcessionaria().getId());

				return stmt;
			}
		}, keyHolder);

		usuarioConcessionaria.setIdUsuarioConcessionaria((Long) keyHolder.getKey());
		return usuarioConcessionaria;
	}

	@Override
	public List<UsuarioConcessionaria> buscarUsuariosDeUmaConcessionaria(Long idConcessionaria) {
		Object[] paramsList = new Object[] { idConcessionaria };
		List<UsuarioConcessionaria> usuarios = new ArrayList<UsuarioConcessionaria>();
		List<Map<String, Object>> returnedRows = jdbcTemplate
				.queryForList(UsuarioConcessionariaDaoContrato.SELECT_USUARIOS_DE_UMA_CONCESSIONARIA, paramsList);

		for (Map<String, Object> row : returnedRows) {
			usuarios.add(usuarioConcessionariaRegra.buildUsuarioConcessionaria(row));
		}

		return usuarios;
	}

	@Override
	public UsuarioConcessionaria buscarUsuarioConcessionariaPorIdUsuario(Long idUsuario) {
		Object[] arrayArguments = new Object[] { idUsuario };
		return (UsuarioConcessionaria) jdbcTemplate.queryForObject(
				UsuarioConcessionariaDaoContrato.SELECT_USUARIO_CONCESSIONARIA_POR_ID_USUARIO, arrayArguments,
				usuarioConcessionariaRowMapper);
	}

	@Override
	public List<NivelUsuarioConcessionaria> buscarNiveisUsuario() {
		List<NivelUsuarioConcessionaria> listaNiveis = new ArrayList<NivelUsuarioConcessionaria>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UsuarioConcessionariaDaoContrato.SELECT_NIVEIS_USUARIO);
		
		for(Map<String, Object> row: rows) {
			listaNiveis.add(nivelUsuarioConcessionariaRegra.buildNivelUsuarioConcessionaria(row));
		}
		
		return listaNiveis;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setUsuarioConcessionariaRowMapper(UsuarioConcessionariaRowMapper usuarioConcessionariaRowMapper) {
		this.usuarioConcessionariaRowMapper = usuarioConcessionariaRowMapper;
	}

	@Autowired
	public void setUsuarioConcessionariaRegra(UsuarioConcessionariaRegra usuarioConcessionariaRegra) {
		this.usuarioConcessionariaRegra = usuarioConcessionariaRegra;
	}

	@Autowired
	public void setNivelUsuarioConcessionariaRegra(NivelUsuarioConcessionariaRegra nivelUsuarioConcessionariaRegra) {
		this.nivelUsuarioConcessionariaRegra = nivelUsuarioConcessionariaRegra;
	}

}

package carros.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.extractor.LojistaRowMapper;
import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.Usuario;

@Repository
public class LojistaDaoImpl implements LojistaDao {
	private JdbcTemplate jdbcTemplate;
	private UsuarioDao usuarioDao;
	private LojistaRowMapper lojistaRowMapper;

	@Override
	public Lojista inserirLojista(Lojista lojista) {
		Usuario usuario = usuarioDao.inserirUsuario(lojista.getUsuario());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						LojistaDaoContrato.INSERIR_LOJISTA,
						new String[] { "id" });
				stmt.setLong(1, usuario.getIdUsuario());

				return stmt;
			}
		}, keyHolder);

		lojista.setIdLojista((Long) keyHolder.getKey());
		return lojista;
	}

	@Override
	public Lojista buscarLojistaPorIdUsuario(Long idUsuario) {
		Object[] arrayArguments = new Object[] { idUsuario };
		System.out.println(idUsuario);
		return (Lojista) jdbcTemplate.queryForObject(
				LojistaDaoContrato.SELECT_LOJISTA_POR_ID_USUARIO,
				arrayArguments, lojistaRowMapper);

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
	public void setLojistaRowMapper(LojistaRowMapper lojistaRowMapper) {
		this.lojistaRowMapper = lojistaRowMapper;
	}

}

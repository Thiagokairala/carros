package carros.dao.pessoa.aparencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.aparencia.extractor.ImagemRowMapper;
import carros.entities.pessoas.aparencia.Imagem;

@Repository
public class ImagemDaoImpl implements ImagemDao {

	private JdbcTemplate jdbcTemplate;
	private ImagemRowMapper imagemRowMapper;

	@Override
	public Imagem inserir(Imagem imagem) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(ImagemDaoContrato.INSERIR_IMAGEM,
						new String[] { "id" });
				stmt.setString(1, imagem.getHashImagem());
				stmt.setString(2, imagem.getCaminhoImagem());
				return stmt;
			}
		}, keyHolder);

		imagem.setId((Long) keyHolder.getKey());

		return imagem;
	}

	@Override
	public Imagem buscarImagem(long id) {
		Object[] paramsArray = new Object[] { id };
		Imagem imagem = jdbcTemplate.queryForObject(ImagemDaoContrato.SELECT_IMAGEM, paramsArray, imagemRowMapper);
		return imagem;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setImagemRowMapper(ImagemRowMapper imagemRowMapper) {
		this.imagemRowMapper = imagemRowMapper;
	}

}

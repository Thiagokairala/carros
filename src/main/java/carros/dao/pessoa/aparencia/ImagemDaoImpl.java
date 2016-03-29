package carros.dao.pessoa.aparencia;

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

import carros.dao.pessoa.aparencia.extractor.ImagemRowMapper;
import carros.entities.pessoas.aparencia.Imagem;
import carros.regras.pessoa.aparencia.ImagemRegra;

@Repository
public class ImagemDaoImpl implements ImagemDao {

	private JdbcTemplate jdbcTemplate;
	private ImagemRowMapper imagemRowMapper;
	private ImagemRegra imagemRegra;

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

	@Override
	public List<Imagem> buscarImagensOferta(Long id) {
		Object[] arrayParams = new Object[] { id };
		List<Imagem> listaDeImagens = new ArrayList<Imagem>();

		List<Map<String, Object>> listFromDb = jdbcTemplate.queryForList(ImagemDaoContrato.SELECT_IMAGEM_AVALIACAO,
				arrayParams);

		for (Map<String, Object> row : listFromDb) {
			listaDeImagens.add(imagemRegra.buildImagem(row));
		}
		return listaDeImagens;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setImagemRowMapper(ImagemRowMapper imagemRowMapper) {
		this.imagemRowMapper = imagemRowMapper;
	}

	@Autowired
	public void setImagemRegra(ImagemRegra imagemRegra) {
		this.imagemRegra = imagemRegra;
	}

}

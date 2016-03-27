package carros.dao.pessoa.aparencia.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import carros.entities.pessoas.aparencia.Imagem;
import carros.regras.pessoa.aparencia.ImagemRegra;

@Component
public class ImagemRowMapper implements RowMapper<Imagem> {
	private ImagemRegra imagemRegra;

	@Override
	public Imagem mapRow(ResultSet rs, int rowNum) throws SQLException {
		Imagem imagem = imagemRegra.buildImagem(rs);
		return imagem;
	}

	@Autowired
	public void setImagemRegra(ImagemRegra imagemRegra) {
		this.imagemRegra = imagemRegra;
	}

}

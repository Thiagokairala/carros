package carros.regras.pessoa.aparencia;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.pessoas.aparencia.Imagem;
import carros.regras.CarrosRegras;

@Component
public class ImagemRegraImpl extends CarrosRegras implements ImagemRegra {

	@Override
	public Imagem buildImagem(ResultSet rs) {
		Imagem imagem = new Imagem();
		imagem.setId(getLong(rs, "idimagme"));
		imagem.setHashImagem(getString(rs, "hash_imagem"));
		imagem.setCaminhoImagem(getString(rs, "endereco_imagem"));
		imagem.setDataInclusao(getGregorianCalendar(rs, "dt_inclusao"));
		return imagem;
	}

	@Override
	public Imagem buildImagem(Map<String, Object> row) {
		Imagem imagem = new Imagem();
		imagem.setId(getLong(row, "idimagem"));
		imagem.setCaminhoImagem(getString(row, "endereco_imagem"));
		imagem.setHashImagem(getString(row, "hash_imagem"));
		imagem.setDataInclusao(getGregorianCalendar(row, "dt_inclusao"));
		return imagem;
	}

}

package carros.regras.pessoa.aparencia;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import carros.entities.pessoas.aparencia.Imagem;
import carros.regras.CarrosRegras;

@Component
public class ImagemRegraImpl extends CarrosRegras implements ImagemRegra {

	@Override
	public Imagem buildImagem(ResultSet rs) {
		Imagem imagem = new Imagem();
		imagem.setCaminhoImagem(getString(rs, "endereco_imagem"));
		imagem.setHashImagem(getString(rs, "hash_imagem"));
		imagem.setDataInclusao(getGregorianCalendar(rs, "dt_inclusao"));
		return imagem;
	}

}

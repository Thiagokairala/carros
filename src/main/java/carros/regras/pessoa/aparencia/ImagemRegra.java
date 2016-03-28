package carros.regras.pessoa.aparencia;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.pessoas.aparencia.Imagem;

public interface ImagemRegra {

	public Imagem buildImagem(ResultSet rs);

	public Imagem buildImagem(Map<String, Object> row);

}

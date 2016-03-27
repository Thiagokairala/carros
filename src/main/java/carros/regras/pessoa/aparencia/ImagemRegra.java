package carros.regras.pessoa.aparencia;

import java.sql.ResultSet;

import carros.entities.pessoas.aparencia.Imagem;

public interface ImagemRegra {

	Imagem buildImagem(ResultSet rs);

}

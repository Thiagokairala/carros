package carros.dao.pessoa.aparencia;

import carros.entities.pessoas.aparencia.Imagem;

public interface ImagemDao {

	public Imagem inserir(Imagem imagem);

	public Imagem buscarImagem(long id);
}

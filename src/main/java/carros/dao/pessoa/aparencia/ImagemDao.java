package carros.dao.pessoa.aparencia;

import java.util.List;

import carros.entities.pessoas.aparencia.Imagem;

public interface ImagemDao {

	public Imagem inserir(Imagem imagem);

	public Imagem buscarImagem(long id);

	public List<Imagem> buscarImagensOferta(Long id);

	public Imagem update(Imagem imagem);
}

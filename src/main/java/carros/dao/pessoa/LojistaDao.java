package carros.dao.pessoa;

import carros.entities.usuarios.Lojista;

public interface LojistaDao {
	public Lojista inserirLojista(Lojista lojista) throws Exception;

	public Lojista buscarLojistaPorIdUsuario(Long idUsuario);
}

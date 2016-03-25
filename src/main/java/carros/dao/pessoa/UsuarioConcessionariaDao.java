package carros.dao.pessoa;

import carros.entities.usuarios.UsuarioConcessionaria;

public interface UsuarioConcessionariaDao {

	public UsuarioConcessionaria inserirUsuarioConcessionaria(
			UsuarioConcessionaria usuarioConcessionaria);

	UsuarioConcessionaria buscarUsuarioConcessionariaPorIdUsuario(Long idUsuario);
}

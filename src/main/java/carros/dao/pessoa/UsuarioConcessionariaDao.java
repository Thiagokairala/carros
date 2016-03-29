package carros.dao.pessoa;

import java.util.List;

import carros.entities.usuarios.UsuarioConcessionaria;

public interface UsuarioConcessionariaDao {

	public UsuarioConcessionaria inserirUsuarioConcessionaria(UsuarioConcessionaria usuarioConcessionaria);

	public UsuarioConcessionaria buscarUsuarioConcessionariaPorIdUsuario(Long idUsuario);

	public List<UsuarioConcessionaria> buscarUsuariosDeUmaConcessionaria(Long idConcessionaria);
}

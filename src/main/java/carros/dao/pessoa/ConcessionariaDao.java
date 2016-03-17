package carros.dao.pessoa;

import carros.entities.usuarios.Concessionaria;

public interface ConcessionariaDao {

	public Concessionaria inserirConcessionaria(Concessionaria concessionaria);

	public void inserirNotaConcessionaria(Concessionaria concessionaria);
	
	public Concessionaria buscarConcessionaria(Concessionaria concessionaria);

	public Concessionaria buscarConcessionariaPorIdUsuario(Long idUsuario);

}

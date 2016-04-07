package carros.dao.pessoa;

import java.util.List;

import carros.entities.usuarios.Concessionaria;

public interface ConcessionariaDao {

	public Concessionaria inserirConcessionaria(Concessionaria concessionaria);

	public void inserirNotaConcessionaria(Concessionaria concessionaria);
	
	public Concessionaria buscarConcessionaria(Concessionaria concessionaria);

	public Concessionaria buscarConcessionariaPorIdUsuario(Long idUsuario);

	public List<Concessionaria> buscarTodasConcessionaria();

	public void update(Concessionaria concessionaria);

}

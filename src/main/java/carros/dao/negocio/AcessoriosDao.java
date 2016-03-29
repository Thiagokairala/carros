package carros.dao.negocio;

import java.util.List;

import carros.entities.negocio.Acessorio;

public interface AcessoriosDao {

	public List<Acessorio> buscarAcessoriosOferta(Long id);

	public List<Acessorio> buscarAcessorios();

	public void inserirAcessorioVeiculo(Acessorio acessorio, Long id);

}

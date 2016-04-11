package carros.dao.negocio;

import java.util.List;

import carros.entities.negocio.ModeloVeiculo;

public interface ModeloVeiculoDao {

	public List<ModeloVeiculo> listarModelosPorMarca(int idMarca);

	public void registrar(ModeloVeiculo modeloVeiculo);

}

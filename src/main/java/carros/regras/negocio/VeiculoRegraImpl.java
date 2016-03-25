package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.negocio.Veiculo;
import carros.regras.CarrosRegras;

@Component
public class VeiculoRegraImpl extends CarrosRegras implements VeiculoRegra {

	private ModeloVeiculoRegra modeloVeiculoRegra;
	private AvaliacaoVeiculoRegra avaliacaoVeiculoRegra;

	@Override
	public Veiculo buildVeiculo(Map<String, Object> row) {
		Veiculo veiculo = new Veiculo();

		veiculo.setId(getLong(row, "idveiculo"));
		veiculo.setAvaliacaoVeiculo(avaliacaoVeiculoRegra
				.buildAvaliacaoVeiculo(row));
		veiculo.setModeloVeiculo(modeloVeiculoRegra.buildModeloVeiculo(row));
		return veiculo;
	}

	@Override
	public Veiculo buildVeiculo(ResultSet rs) {
		Veiculo veiculo = new Veiculo();

		veiculo.setId(getLong(rs, "idveiculo"));
		veiculo.setAvaliacaoVeiculo(avaliacaoVeiculoRegra
				.buildAvaliacaoVeiculo(rs));
		veiculo.setModeloVeiculo(modeloVeiculoRegra.buildModeloVeiculo(rs));
		return veiculo;
	}

	@Autowired
	public void setModeloVeiculoRegra(ModeloVeiculoRegra modeloVeiculoRegra) {
		this.modeloVeiculoRegra = modeloVeiculoRegra;
	}

	@Autowired
	public void setAvaliacaoVeiculoRegra(
			AvaliacaoVeiculoRegra avaliacaoVeiculoRegra) {
		this.avaliacaoVeiculoRegra = avaliacaoVeiculoRegra;
	}

}

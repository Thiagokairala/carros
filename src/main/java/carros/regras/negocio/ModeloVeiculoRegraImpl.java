package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.negocio.ModeloVeiculo;
import carros.regras.CarrosRegras;

@Component
public class ModeloVeiculoRegraImpl extends CarrosRegras implements
		ModeloVeiculoRegra {

	private MarcaVeiculoRegra marcaVeiculoRegra;
	private TipoVeiculoRegra tipoVeiculoRegra;

	@Override
	public ModeloVeiculo buildModeloVeiculo(Map<String, Object> row) {
		ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
		modeloVeiculo.setId(getLong(row, "idmodelo_veiculo"));
		modeloVeiculo.setNome(getString(row, "txt_nome_modelo"));
		modeloVeiculo.setMarcaVeiculo(marcaVeiculoRegra.buildMarcaVeiculo(row));
		modeloVeiculo.setTipoVeiculo(tipoVeiculoRegra.buildTipoVeiculo(row));

		return modeloVeiculo;
	}


	@Override
	public ModeloVeiculo buildModeloVeiculo(ResultSet rs) {
		ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
		modeloVeiculo.setId(getLong(rs, "idmodelo_veiculo"));
		modeloVeiculo.setNome(getString(rs, "txt_nome_modelo"));
		modeloVeiculo.setMarcaVeiculo(marcaVeiculoRegra.buildMarcaVeiculo(rs));
		modeloVeiculo.setTipoVeiculo(tipoVeiculoRegra.buildTipoVeiculo(rs));

		return modeloVeiculo;
	}

	
	@Autowired
	public void setMarcaVeiculoRegra(MarcaVeiculoRegra marcaVeiculoRegra) {
		this.marcaVeiculoRegra = marcaVeiculoRegra;
	}

	@Autowired
	public void setTipoVeiculoRegra(TipoVeiculoRegra tipoVeiculoRegra) {
		this.tipoVeiculoRegra = tipoVeiculoRegra;
	}

}

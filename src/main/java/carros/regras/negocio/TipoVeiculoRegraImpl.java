package carros.regras.negocio;

import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.negocio.TipoVeiculo;
import carros.regras.CarrosRegras;

@Component
public class TipoVeiculoRegraImpl extends CarrosRegras implements
		TipoVeiculoRegra {

	@Override
	public TipoVeiculo buildTipoVeiculo(Map<String, Object> row) {
		TipoVeiculo tipoVeiculo = new TipoVeiculo();

		tipoVeiculo.setId(getLong(row, "idtipo_veiculo"));
		tipoVeiculo.setNomeDoTipo(getString(row, "txt_tipo_veiculo"));

		return tipoVeiculo;
	}

}

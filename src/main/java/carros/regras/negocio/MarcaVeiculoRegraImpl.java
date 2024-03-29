package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.negocio.MarcaVeiculo;
import carros.regras.CarrosRegras;

@Component
public class MarcaVeiculoRegraImpl extends CarrosRegras implements
		MarcaVeiculoRegra {

	@Override
	public MarcaVeiculo buildMarcaVeiculo(Map<String, Object> row) {
		MarcaVeiculo marcaVeiculo = new MarcaVeiculo();
		marcaVeiculo.setId(getLong(row, "idmarca_veiculo"));
		marcaVeiculo.setNome(getString(row, "txt_nome_marca"));
		return marcaVeiculo;
	}

	@Override
	public MarcaVeiculo buildMarcaVeiculo(ResultSet rs) {
		MarcaVeiculo marcaVeiculo = new MarcaVeiculo();
		marcaVeiculo.setId(getLong(rs, "idmarca_veiculo"));
		marcaVeiculo.setNome(getString(rs, "txt_nome_marca"));
		return marcaVeiculo;
	}
}

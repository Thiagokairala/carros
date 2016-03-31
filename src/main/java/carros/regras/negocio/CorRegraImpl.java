package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.negocio.CorVeiculo;
import carros.regras.CarrosRegras;

@Component
public class CorRegraImpl extends CarrosRegras implements CorRegra {

	@Override
	public CorVeiculo buildCor(Map<String, Object> row) {
		CorVeiculo cor = new CorVeiculo();
		cor.setIdCor(getLong(row, "idcor_veiculo"));
		cor.setCor(getString(row, "txt_cor"));
		return cor;
	}

	@Override
	public CorVeiculo buildCor(ResultSet rs) {
		CorVeiculo cor = new CorVeiculo();
		cor.setIdCor(getLong(rs, "idcor_veiculo"));
		cor.setCor(getString(rs, "txt_cor"));
		return cor;
	}

}

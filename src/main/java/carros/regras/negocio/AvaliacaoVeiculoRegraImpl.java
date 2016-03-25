package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.negocio.AvaliacaoVeiculo;
import carros.regras.CarrosRegras;

@Component
public class AvaliacaoVeiculoRegraImpl extends CarrosRegras implements
		AvaliacaoVeiculoRegra {

	@Override
	public AvaliacaoVeiculo buildAvaliacaoVeiculo(Map<String, Object> row) {
		AvaliacaoVeiculo avaliacaoVeiculo = new AvaliacaoVeiculo();

		avaliacaoVeiculo.setId(getLong(row, "idavaliacao_veiculo"));
		avaliacaoVeiculo.setDescricao(getString(row, "txt_descricao_avaliacao"));
		avaliacaoVeiculo.setPrecoParaConserto(getBidDecimal(row,
				"db_preco_para_conserto"));
		avaliacaoVeiculo.setKmRodado(getInt(row, "km_rodado"));
		return avaliacaoVeiculo;
	}

	@Override
	public AvaliacaoVeiculo buildAvaliacaoVeiculo(ResultSet rs) {
		AvaliacaoVeiculo avaliacaoVeiculo = new AvaliacaoVeiculo();

		avaliacaoVeiculo.setId(getLong(rs, "idavaliacao_veiculo"));
		avaliacaoVeiculo.setDescricao(getString(rs, "txt_descricao_avaliacao"));
		avaliacaoVeiculo.setPrecoParaConserto(getBidDecimal(rs,
				"db_preco_para_conserto"));
		avaliacaoVeiculo.setKmRodado(getInt(rs, "km_rodado"));
		return avaliacaoVeiculo;
	}

}

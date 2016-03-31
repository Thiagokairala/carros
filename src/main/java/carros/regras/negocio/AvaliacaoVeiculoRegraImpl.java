package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.negocio.AvaliacaoVeiculo;
import carros.regras.CarrosRegras;
import carros.regras.pessoa.aparencia.ImagemRegra;

@Component
public class AvaliacaoVeiculoRegraImpl extends CarrosRegras implements AvaliacaoVeiculoRegra {
	private ImagemRegra imagemRegra;
	private CorRegra corRegra;

	@Override
	public AvaliacaoVeiculo buildAvaliacaoVeiculo(Map<String, Object> row) {
		AvaliacaoVeiculo avaliacaoVeiculo = new AvaliacaoVeiculo();

		avaliacaoVeiculo.setId(getLong(row, "idavaliacao_veiculo"));
		avaliacaoVeiculo.setDescricao(getString(row, "txt_descricao_avaliacao"));
		avaliacaoVeiculo.setPrecoParaConserto(getBidDecimal(row, "db_preco_para_conserto"));
		avaliacaoVeiculo.setKmRodado(getInt(row, "km_rodado"));
		avaliacaoVeiculo.setAno(getInt(row, "int_ano"));
		avaliacaoVeiculo.setModelo(getInt(row, "int_modelo"));
		avaliacaoVeiculo.setCor(corRegra.buildCor(row));
		
		avaliacaoVeiculo.setImages(Arrays.asList(imagemRegra.buildImagem(row)));
		return avaliacaoVeiculo;
	}

	@Override
	public AvaliacaoVeiculo buildAvaliacaoVeiculo(ResultSet rs) {
		AvaliacaoVeiculo avaliacaoVeiculo = new AvaliacaoVeiculo();

		avaliacaoVeiculo.setId(getLong(rs, "idavaliacao_veiculo"));
		avaliacaoVeiculo.setDescricao(getString(rs, "txt_descricao_avaliacao"));
		avaliacaoVeiculo.setPrecoParaConserto(getBidDecimal(rs, "db_preco_para_conserto"));
		avaliacaoVeiculo.setKmRodado(getInt(rs, "km_rodado"));
		avaliacaoVeiculo.setAno(getInt(rs, "int_ano"));
		avaliacaoVeiculo.setModelo(getInt(rs, "int_modelo"));
		avaliacaoVeiculo.setCor(corRegra.buildCor(rs));
		
		avaliacaoVeiculo.setImages(Arrays.asList(imagemRegra.buildImagem(rs)));
		return avaliacaoVeiculo;
	}

	@Autowired
	public void setCorRegra(CorRegra corRegra) {
		this.corRegra = corRegra;
	}

	@Autowired
	public void setImagemRegra(ImagemRegra imagemRegra) {
		this.imagemRegra = imagemRegra;
	}

}

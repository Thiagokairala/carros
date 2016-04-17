package carros.dao.negocio;

public final class AvaliacaoVeiculoDaoContract {
	public static final String INSERIR_AVALIACAO_VEICULO = "INSERT INTO avaliacao_veiculo "
			+ "(txt_descricao_avaliacao, db_preco_para_conserto, km_rodado, int_ano, int_modelo, cor_veiculo_idcor_veiculo) VALUES (?, ?, ?, ?, ?, ?)";
}

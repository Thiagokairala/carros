package carros.dao.negocio;

public final class AvaliacaoVeiculoDaoContract {
	public static final String INSERIR_AVALIACAO_VEICULO = "INSERT INTO avaliacao_veiculo "
			+ "(txt_descricao_avaliacao, db_preco_para_conserto, km_rodado) VALUES (?, ?, ?)";
}

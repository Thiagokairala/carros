package carros.dao.negocio;

public final class VeiculoDaoContract {
	public static final String SELECT_TODOS_VEICULOS = "SELECT * FROM veiculo";
	protected static final String INSERIR_VEICULOS = "INSERT INTO veiculo "
			+ "(modelo_veiculo_idmodelo_veiculo, avaliacao_veiculo_idavaliacao_veiculo) "
			+ "VALUES (?, ?)";
}

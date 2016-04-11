package carros.dao.negocio;

public final class ModeloVeiculoDaoContrato {

	public static final String SELECT_MODELOS_POR_MARCA = "SELECT * FROM modelo_veiculo "
			+ "WHERE marca_veiculo_idmarca_veiculo = ?";
	public static final String INSERIR_MODELO_VEICULO = "INSERT INTO modelo_veiculo "
			+ "(txt_nome_modelo, marca_veiculo_idmarca_veiculo, tipo_veiculo_idtipo_veiculo)"
			+ "VALUES (?, ?, ?)";

}

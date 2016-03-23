package carros.dao.negocio;

public final class ModeloVeiculoDaoContrato {

	public static final String SELECT_MODELOS_POR_MARCA = "SELECT * FROM modelo_veiculo "
			+ "WHERE marca_veiculo_idmarca_veiculo = ?";

}

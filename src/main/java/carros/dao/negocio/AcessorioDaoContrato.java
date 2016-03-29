package carros.dao.negocio;

public final class AcessorioDaoContrato {

	public static final String SELECT_ACESSORIOS_OFERTA = "SELECT * FROM acessorio_veiculo "
			+ "JOIN veiculo_has_acessorio_veiculo ON veiculo_has_acessorio_veiculo.acessorio_veiculo_idacessorio_veiculo = acessorio_veiculo.idacessorio_veiculo "
			+ "JOIN veiculo ON veiculo_has_acessorio_veiculo.veiculo_idveiculo = veiculo.idveiculo "
			+ "WHERE veiculo.idveiculo = ? AND veiculo_has_acessorio_veiculo.boo_possui_acessorio = true";
	public static final String SELECT_ACESSORIOS = "SELECT * FROM acessorio_veiculo";
	public static final String INSERIR_ACESSORIO_VEICULO = "INSERT INTO veiculo_has_acessorio_veiculo "
			+ "(veiculo_idveiculo, acessorio_veiculo_idacessorio_veiculo, boo_possui_acessorio) "
			+ "VALUES (?, ?, ?)";

}

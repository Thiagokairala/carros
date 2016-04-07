package carros.dao.residenciais;

public final class EnderecoDaoContrato {
	public final static String INSERIR_ENDERECO = "INSERT INTO endereco "
			+ "(txt_cep, txt_endereco) " + "VALUES (?, ?)";
	public static final String UPDATE_ENDERECO = "UPDATE endereco SET txt_cep = ?, txt_endereco = ? WHERE idendereco = ?";

}

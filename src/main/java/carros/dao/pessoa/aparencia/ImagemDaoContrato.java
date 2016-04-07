package carros.dao.pessoa.aparencia;

public final class ImagemDaoContrato {
	public static final Long DEFAULT_ID = new Long(1);

	public static final String INSERIR_IMAGEM = "INSERT INTO imagem (hash_imagem, endereco_imagem, dt_inclusao) "
			+ "VALUES (?, ?, now())";

	public static final String SELECT_IMAGEM = "SELECT * FROM imagem " + "WHERE idimagem = ?";

	public static final String SELECT_IMAGEM_AVALIACAO = "SELECT * FROM imagem "
			+ "JOIN avaliacao_veiculo_has_imagem ON imagem.idimagem = avaliacao_veiculo_has_imagem.imagem_idimagem "
			+ "WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = ?";

	protected static final String UPDATE_IMAGEM = "UPDATE imagem SET hash_imagem=?, endereco_imagem=?, dt_inclusao=now() WHERE idimagem=?";
}

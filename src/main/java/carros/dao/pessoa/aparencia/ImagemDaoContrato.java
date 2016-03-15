package carros.dao.pessoa.aparencia;

public final class ImagemDaoContrato {
	public static final Long DEFAULT_ID = new Long(1);

	public static final String INSERIR_IMAGEM = "INSERT INTO imagem (hash_imagem, endereco_imagem, dt_inclusao) "
			+ "VALUES (?, ?, now())";
}

package carros.dao.pessoa;

public final class ConcessionariaDaoContrato {
	public static final String INSERIR_CONCESSIONARIA = "INSERT INTO concessionaria "
			+ "(usuario_idusuario) VALUES (?)";

	public static final String INSERIR_AVALIACAO_CONCESSIONARIA = "UPDATE concessionaria SET fl_nota_avaliacao = ?, int_numero_de_avaliacoes = ? WHERE idconcessionaria = ?";

	public static final String SELECT_CONCESSIONARIA = "SELECT * FROM concessionaria WHERE idconcessionaria = ?";
}

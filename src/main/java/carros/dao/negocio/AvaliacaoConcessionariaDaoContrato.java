package carros.dao.negocio;

public final class AvaliacaoConcessionariaDaoContrato {
	public static final String INSERIR_AVALIACAO_CONCESSIONARIA = "INSERT INTO avaliacao_concessionaria "
			+ "(int_nota_documentacao, int_nota_informacao, int_nota_velocidade, fl_nota_geral,"
			+ " concessionaria_idconcessionaria) VALUES (?, ?, ?, ?, ?)";
}

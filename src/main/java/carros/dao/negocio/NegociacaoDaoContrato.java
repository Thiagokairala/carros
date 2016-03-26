package carros.dao.negocio;

public final class NegociacaoDaoContrato {

	public static final String INSERT_NEGOCIACAO = "INSERT INTO lojista_fez_oferta "
			+ "(oferta_idoferta, lojista_idlojista, chat_idchat, dt_horario_oferta, db_preco_oferecido) "
			+ "VALUES (?, ?, ?, now(), ?)";
	public static final String INSERT_NEGOCIACAO_JA_FINALIZADA = "INSERT INTO lojista_fez_oferta "
			+ "(oferta_idoferta, lojista_idlojista, dt_horario_oferta, db_preco_oferecido) "
			+ "VALUES (?, ?, now(), ?)";

}

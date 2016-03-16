package carros.dao.pessoa;

public final class UsuarioConcessionariaDaoContrato {
	public final static String INSERIR_USUARIO_CONCESSIONARIA = "INSERT INTO usuario_concessionaria"
			+ " (concessionaria_idconcessionaria,"
			+ " usuario_idusuario, "
			+ "nivel_usuario_concessionaria_idnivel_usuario_concessionaria) "
			+ "VALUES (?, ?, ?)";
}

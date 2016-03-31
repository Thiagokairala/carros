package carros.dao.pessoa;

public final class LojistaDaoContrato {
	public final static String INSERIR_LOJISTA = "INSERT INTO lojista (usuario_idusuario) VALUES (?)";
	public static final String SELECT_LOJISTA_POR_ID_USUARIO = "SELECT * FROM lojista "
			+ "JOIN usuario "
			+ "ON usuario.idusuario = lojista.usuario_idusuario "
			+ "JOIN tipo_usuario "
			+ "ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "JOIN pessoa "
			+ "ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN endereco "
			+ "ON endereco.idendereco = pessoa.endereco_idendereco "
			+ "JOIN telefone "
			+ "ON telefone.idtelefone = pessoa.idpessoa "
			+ "JOIN imagem "
			+ "ON imagem.idimagem = pessoa.imagem_idimagem "
			+ "WHERE lojista.usuario_idusuario = ?";
}

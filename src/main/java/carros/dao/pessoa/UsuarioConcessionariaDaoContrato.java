package carros.dao.pessoa;

public final class UsuarioConcessionariaDaoContrato {
	public final static String INSERIR_USUARIO_CONCESSIONARIA = "INSERT INTO usuario_concessionaria"
			+ " (concessionaria_idconcessionaria,"
			+ " usuario_idusuario, "
			+ "nivel_usuario_concessionaria_idnivel_usuario_concessionaria) "
			+ "VALUES (?, ?, ?)";
	public static final String SELECT_USUARIO_CONCESSIONARIA_POR_ID_USUARIO = "SELECT * FROM usuario_concessionaria "
			+ "JOIN usuario ON usuario_concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN nivel_usuario_concessionaria ON nivel_usuario_concessionaria.idnivel_usuario_concessionaria = "
			+ "usuario_concessionaria.nivel_usuario_concessionaria_idnivel_usuario_concessionaria "
			+ "JOIN pessoa ON usuario.pessoa_idpessoa = pessoa.idpessoa "
			+ "JOIN tipo_usuario ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "JOIN endereco ON pessoa.endereco_idendereco = endereco.idendereco "
			+ "JOIN telefone ON pessoa.telefone_idtelefone = telefone.idtelefone "
			+ "INNER JOIN ( "
			+ "	SELECT idconcessionaria, fl_nota_avaliacao, int_numero_de_avaliacoes "
			+ "    FROM concessionaria "
			+ "    ) AS concessionaria "
			+ "ON concessionaria.idconcessionaria = usuario_concessionaria.concessionaria_idconcessionaria "
			+ "JOIN imagem "
			+ "ON imagem.idimagem = pessoa.imagem_idimagem "
			+ "WHERE usuario_idusuario = ?";
	public static final String SELECT_USUARIOS_DE_UMA_CONCESSIONARIA = "SELECT * FROM usuario_concessionaria "
			+ "JOIN usuario ON usuario.idusuario = usuario_concessionaria.usuario_idusuario "
			+ "WHERE concessionaria_idconcessionaria = ?";
}

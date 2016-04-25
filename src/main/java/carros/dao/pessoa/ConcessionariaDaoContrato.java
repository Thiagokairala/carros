package carros.dao.pessoa;

public final class ConcessionariaDaoContrato {
	public static final String INSERIR_CONCESSIONARIA = "INSERT INTO concessionaria "
			+ "(usuario_idusuario, txt_responsavel) VALUES (?, ?)";

	public static final String INSERIR_AVALIACAO_CONCESSIONARIA = "UPDATE concessionaria SET fl_nota_avaliacao = ?, int_numero_de_avaliacoes = ? WHERE idconcessionaria = ?";

	public static final String SELECT_CONCESSIONARIA = "SELECT * FROM concessionaria WHERE idconcessionaria = ?";

	public static final String SELECT_CONCESSIONARIA_BY_ID_USUARIO = "SELECT * FROM concessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON usuario.pessoa_idpessoa = pessoa.idpessoa "
			+ "JOIN tipo_usuario ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "JOIN endereco ON pessoa.endereco_idendereco = endereco.idendereco "
			+ "JOIN telefone ON pessoa.telefone_idtelefone = telefone.idtelefone "
			+ "JOIN imagem ON pessoa.imagem_idimagem = imagem.idimagem " + "WHERE usuario_idusuario = ?";

	public static final String SELECT_TODAS_CONCESSIONARIO = "SELECT * FROM concessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON usuario.pessoa_idpessoa = pessoa.idpessoa "
			+ "JOIN tipo_usuario ON usuario.tipo_usuario_idtipo_usuario = tipo_usuario.idtipo_usuario "
			+ "JOIN endereco ON pessoa.endereco_idendereco = endereco.idendereco "
			+ "JOIN imagem ON pessoa.imagem_idimagem = imagem.idimagem "
			+ "JOIN telefone ON pessoa.telefone_idtelefone = telefone.idtelefone";
}

package carros.dao.negocio;

public class OfertaDaoContrato {
	public static final Integer NUMERO_DIAS_ATE_AVALIACAO = 10;

	public static final String SELECT_TODAS_OFERTAS = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "marca_veiculo.*, "
			+ "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "cor_veiculo.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE oferta.bool_finalizada = false " + "ORDER BY dt_criado DESC LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_TIPO = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "marca_veiculo.*, "
			+ "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "cor_veiculo.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND tipo_veiculo.idtipo_veiculo = ? " + "LIMIT ?, ?  ORDER BY dt_criado DESC";

	public static final String SELECT_OFERTAS_POR_MARCA = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "marca_veiculo.*, "
			+ "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "cor_veiculo.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND marca_veiculo.idmarca_veiculo = ? " + "ORDER BY dt_criado DESC LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_RANGE_DE_PRECO = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "cor_veiculo.*, "
			+ "marca_veiculo.*, " + "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND oferta.db_preco_oferta BETWEEN ? AND ? " + "ORDER BY dt_criado DESC LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_FILTRO = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "cor_veiculo.*, "
			+ "marca_veiculo.*, " + "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE oferta.bool_finalizada = false " + "AND" + "	( " + "		marca_veiculo.txt_nome_marca LIKE ? "
			+ "		OR modelo_veiculo.txt_nome_modelo LIKE ? " + "	) " + "   ORDER BY dt_criado DESC LIMIT ?, ?";

	protected static final String INSERIR_OFERTA = "INSERT INTO oferta "
			+ "(concessionaria_idconcessionaria, veiculo_idveiculo, db_preco_oferta, dt_criado) "
			+ "VALUES (?, ?, ?, now())";

	public static final String SELECT_OFERTA_POR_ID = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "cor_veiculo.*, "
			+ "marca_veiculo.*, " + "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE idoferta = ?  ORDER BY dt_criado DESC";

	public static final String FINALIZAR_OFERTA = "UPDATE oferta "
			+ "SET bool_finalizada = true, dt_finalizado = now(), bool_avaliada = false, dt_avaliacao_sera_feita = now() + INTERVAL ? DAY, finalizado_por_lojista = ? "
			+ "WHERE idoferta = ?";

	public static final String SELECT_OFERTA_POR_CONCESSIONARIA = "SELECT concessionaria.*," + "usuario.*, "
			+ "pessoa.txt_nome_de_tela, " + "veiculo.*, " + "modelo_veiculo.*, " + "cor_veiculo.*, "
			+ "marca_veiculo.*, " + "tipo_veiculo.*, " + "avaliacao_veiculo.*, " + "oferta.*, " + "( "
			+ "	SELECT avaliacao_veiculo_has_imagem.imagem_idimagem FROM avaliacao_veiculo_has_imagem "
			+ "    WHERE avaliacao_veiculo_has_imagem.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "    LIMIT 1 " + ") AS idimagem " + "FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "WHERE concessionaria.idconcessionaria = ? AND oferta.bool_finalizada = false  ORDER BY dt_criado DESC";

	public static final String BUSCAR_OFERTA_POR_CHAT = "SELECT * FROM oferta "
			+ "JOIN lojista_fez_oferta ON oferta.idoferta = lojista_fez_oferta.oferta_idoferta "
			+ "WHERE chat_idchat = ?";

	public static final String LOJISTA_JA_FEZ_OFERTA = "SELECT * FROM lojista_fez_oferta "
			+ "WHERE oferta_idoferta = ? " + "AND lojista_idlojista = ?";

	public static final String BUSCAR_OFERTAS_FINALIZADAS_POR_PERIODO = "SELECT * FROM oferta WHERE concessionaria_idconcessionaria = ? AND bool_finalizada = true AND dt_finalizado BETWEEN ? AND ?";

	public static final String INSERIR_IMAGEM_OFERTA = "INSERT INTO avaliacao_veiculo_has_imagem (avaliacao_veiculo_idavaliacao_carro, imagem_idimagem) VALUES (?, ?)";

	public static final String LISTAR_OFERTAS_NAO_AVALIADAS =  "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_veiculo = avaliacao_veiculo.idavaliacao_veiculo "
			+ "JOIN cor_veiculo ON avaliacao_veiculo.cor_veiculo_idcor_veiculo = cor_veiculo.idcor_veiculo "
			+ "JOIN imagem ON pessoa.imagem_idimagem = imagem.idimagem "
			+ "WHERE oferta.bool_finalizada = true "
			+ "AND oferta.bool_avaliada = false "
			+ "AND oferta.finalizado_por_lojista = ? "
			+ "AND dt_avaliacao_sera_feita < now();";

	public static final String SET_OFERTA_AVALIADA = "UPDATE oferta "
			+ "SET bool_avaliada = true WHERE idoferta = ?";
}
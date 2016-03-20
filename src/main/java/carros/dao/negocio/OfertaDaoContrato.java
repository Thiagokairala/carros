package carros.dao.negocio;

public class OfertaDaoContrato {

	public static final String SELECT_TODAS_OFERTAS = "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "WHERE oferta.bool_finalizada = false " + "LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_TIPO = "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND tipo_veiculo.idtipo_veiculo = ? "
			+ "LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_MARCA = "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND marca_veiculo.idmarca_veiculo = ? "
			+ "LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_RANGE_DE_PRECO = "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "WHERE oferta.bool_finalizada = false AND oferta.db_preco_oferta BETWEEN ? AND ? "
			+ "LIMIT ?, ?";

	public static final String SELECT_OFERTAS_POR_FILTRO = "SELECT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "JOIN avaliacao_veiculo ON veiculo.avaliacao_veiculo_idavaliacao_carro = avaliacao_veiculo.idavaliacao_veiculo "
			+ "WHERE oferta.bool_finalizada = false "
			+ "AND"
			+ "	( "
			+ "		marca_veiculo.txt_nome_marca LIKE ? "
			+ "		OR modelo_veiculo.txt_nome_modelo LIKE ? "
			+ "	) "
			+ "LIMIT ?, ?";
}

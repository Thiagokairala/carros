package carros.dao.negocio;

public class OfertaDaoContrato {

	public static final String SELECT_TODAS_OFERTAS = "SELCT * FROM oferta "
			+ "JOIN concessionaria ON oferta.concessionaria_idconcessionaria = concessionaria.idconcessionaria "
			+ "JOIN usuario ON concessionaria.usuario_idusuario = usuario.idusuario "
			+ "JOIN pessoa ON pessoa.idpessoa = usuario.pessoa_idpessoa "
			+ "JOIN veiculo ON oferta.veiculo_idveiculo = veiculo.idveiculo "
			+ "JOIN modelo_veiculo ON veiculo.modelo_veiculo_idmodelo_veiculo = modelo_veiculo.idmodelo_veiculo "
			+ "JOIN marca_veiculo ON marca_veiculo.idmarca_veiculo = modelo_veiculo.marca_veiculo_idmarca_veiculo "
			+ "JOIN tipo_veiculo ON tipo_veiculo.idtipo_veiculo = modelo_veiculo.tipo_veiculo_idtipo_veiculo "
			+ "WHERE oferta.bool_finalizado = false";

}

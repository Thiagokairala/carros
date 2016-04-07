package carros.dao.residenciais;

public final class TelefoneDaoContrato {
	public final static String INSERIR_TELEFONE = "INSERT INTO telefone (txt_ddd, txt_numero) VALUES (?, ?)";
	public static final String UPDATE_TELEFONE = "UPDATE telefone SET txt_ddd = ?, txt_numero = ? WHERE idtelefone = ?";
}

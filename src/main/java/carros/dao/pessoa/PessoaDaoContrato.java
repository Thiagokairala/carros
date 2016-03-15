package carros.dao.pessoa;

public final class PessoaDaoContrato {
	public static String INSERIR_PESSOA = "INSERT INTO pessoa "
			+ "(txt_doc_identificacao, txt_nome, txt_nome_de_tela, "
			+ "dt_criacao_sistema, endereco_idendereco, telefone_idtelefone) "
			+ "VALUES " + "(?, ?, ?, now(), ?, ?)";
}

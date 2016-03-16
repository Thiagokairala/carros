package carros.rule.pessoa;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.pessoas.Pessoa;
import carros.regras.CarrosRegras;
import carros.rule.residenciais.EnderecoRegra;
import carros.rule.residenciais.TelefoneRegra;

@Component
public class PessoaRegraImpl extends CarrosRegras implements PessoaRegra {

	private TelefoneRegra telefoneRegra;
	private EnderecoRegra enderecoRegra;

	@Override
	public Pessoa buildPessoa(ResultSet rs) {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(getLong(rs, "idpessoa"));
		pessoa.setDocIdentificacao(getString(rs, "txt_doc_identificacao"));
		pessoa.setNome(getString(rs, "txt_nome"));
		pessoa.setNomeDeTela(getString(rs, "txt_nome_de_tela"));
		pessoa.setDataCriacao(getGregorianCalendar(rs, "dt_criacao_sistema"));
		pessoa.setTelefone(telefoneRegra.buildTelefone(rs));
		pessoa.setEndereco(enderecoRegra.buildEndereco(rs));
		return pessoa;
	}

	@Autowired
	public void setTelefoneRegra(TelefoneRegra telefoneRegra) {
		this.telefoneRegra = telefoneRegra;
	}

	@Autowired
	public void setEnderecoRegra(EnderecoRegra enderecoRegra) {
		this.enderecoRegra = enderecoRegra;
	}

}

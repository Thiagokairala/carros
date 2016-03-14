package carros.dao.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.pessoas.Pessoa;

@Repository
public class PessoaDaoImpl implements PessoaDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void inserirPessoa(Pessoa pessoa) {

	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}

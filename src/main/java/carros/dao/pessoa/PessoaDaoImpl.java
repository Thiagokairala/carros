package carros.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.aparencia.ImagemDao;
import carros.dao.pessoa.aparencia.ImagemDaoContrato;
import carros.dao.residenciais.EnderecoDao;
import carros.dao.residenciais.TelefoneDao;
import carros.entities.pessoas.Pessoa;
import carros.entities.pessoas.aparencia.Imagem;

@Repository
public class PessoaDaoImpl implements PessoaDao {

	private JdbcTemplate jdbcTemplate;

	private EnderecoDao enderecoDao;
	private TelefoneDao telefoneDao;
	private ImagemDao imagemDao;

	@Override
	public Pessoa inserirPessoa(Pessoa pessoa) {
		pessoa.setTelefone(telefoneDao.inserir(pessoa.getTelefone()));
		pessoa.setEndereco(enderecoDao.inserir(pessoa.getEndereco()));
		try {
			pessoa.setImagem(imagemDao.inserir(pessoa.getImagem()));
		} catch (NullPointerException e) {
			Imagem imagem = new Imagem();
			imagem.setId(ImagemDaoContrato.DEFAULT_ID);
			pessoa.setImagem(imagem);
		}
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection
						.prepareStatement(PessoaDaoContrato.INSERIR_PESSOA,
								new String[] { "id" });
				stmt.setString(1, pessoa.getDocIdentificacao());
				stmt.setString(2, pessoa.getNome());
				stmt.setString(3, pessoa.getNomeDeTela());
				stmt.setLong(4, pessoa.getEndereco().getId());
				stmt.setLong(5, pessoa.getTelefone().getId());
				stmt.setLong(6, pessoa.getImagem().getId());

				return stmt;
			}
		}, keyHolder);

		pessoa.setIdPessoa((Long) keyHolder.getKey());
		return pessoa;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	@Autowired
	public void setTelefoneDao(TelefoneDao telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	@Autowired
	public void setImagemDao(ImagemDao imagemDao) {
		this.imagemDao = imagemDao;
	}

}

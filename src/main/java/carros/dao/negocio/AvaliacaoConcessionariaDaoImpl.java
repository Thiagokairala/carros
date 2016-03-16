package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.ConcessionariaDao;
import carros.entities.negocio.AvaliacaoConcessionaria;

@Repository
public class AvaliacaoConcessionariaDaoImpl implements
		AvaliacaoConcessionariaDao {

	private JdbcTemplate jdbcTemplate;
	private ConcessionariaDao concessionariaDao;

	@Override
	public AvaliacaoConcessionaria avaliarConcessionaria(
			AvaliacaoConcessionaria avaliacaoConcessionaria) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		concessionariaDao.inserirNotaConcessionaria(avaliacaoConcessionaria.getConcessionaria());

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection
						.prepareStatement(
								AvaliacaoConcessionariaDaoContrato.INSERIR_AVALIACAO_CONCESSIONARIA,
								new String[] { "id" });
				stmt.setInt(1, avaliacaoConcessionaria.getNotaDocumentacao());
				stmt.setInt(2, avaliacaoConcessionaria.getNotaInformacao());
				stmt.setInt(3, avaliacaoConcessionaria.getNotaVelocidade());
				stmt.setDouble(4, avaliacaoConcessionaria.getNotaGeral());
				stmt.setLong(5, avaliacaoConcessionaria.getConcessionaria()
						.getIdConcessionaria());
				return stmt;
			}
		}, keyHolder);

		avaliacaoConcessionaria.setId((Long) keyHolder.getKey());
		return avaliacaoConcessionaria;
	}

	@Autowired
	public void setConcessionariaDao(ConcessionariaDao concessionariaDao) {
		this.concessionariaDao = concessionariaDao;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}

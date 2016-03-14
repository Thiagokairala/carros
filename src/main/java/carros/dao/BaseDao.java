package carros.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {
	protected static final int DEFAULT_ROWCOUNT = 10;

	private JdbcTemplate jdbcTemplate;

	public BaseDao() {
		super();
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
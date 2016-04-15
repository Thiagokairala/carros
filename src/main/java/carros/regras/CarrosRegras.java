package carros.regras;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CarrosRegras {
	private static Logger logger = LoggerFactory.getLogger(CarrosRegras.class);

	public String getString(ResultSet rs, String columnName) {
		String returnString = "Nothing on field";
		try {
			returnString = rs.getString(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}
		return returnString;
	}

	public String getString(Map<String, Object> row, String columnName) {
		String returnString = "Nothing on field";
		returnString = (String) row.get(columnName);
		return returnString;
	}

	public int getInt(ResultSet rs, String columnName) {
		int returnInt = -1;

		try {
			returnInt = rs.getInt(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return returnInt;
	}

	public int getInt(Map<String, Object> row, String columnName) {
		int returnInt = -1;
		try {
			returnInt = (int) row.get(columnName);
		} catch (NullPointerException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return returnInt;

	}

	public GregorianCalendar getGregorianCalendar(ResultSet rs, String columnName) {
		GregorianCalendar calendarReturn = new GregorianCalendar();
		try {
			calendarReturn.setTime(rs.getDate(columnName));
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}
		return calendarReturn;
	}

	public GregorianCalendar getGregorianCalendar(Map<String, Object> row, String columnName) {
		try {
			GregorianCalendar calendarReturn = new GregorianCalendar();
			calendarReturn.setTimeInMillis(((Timestamp) row.get(columnName)).getTime());
			return calendarReturn;
		} catch (Exception e) {
			logger.warn("Field " + columnName + " not in the resultSet");
			return null;
		}

	}

	public Boolean getBoolean(ResultSet rs, String columnName) {
		Boolean bool = false;
		try {
			bool = rs.getBoolean(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return bool;
	}

	public Boolean getBoolean(Map<String, Object> row, String columnName) {
		Boolean bool = false;

		try {
			bool = (Boolean) row.get(columnName);
		} catch (Exception e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}
		return bool;
	}

	public Long getLong(ResultSet rs, String columnName) {
		Long returnLong = new Long(-1);

		try {
			returnLong = rs.getLong(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return returnLong;
	}

	public Long getLong(Map<String, Object> row, String columnName) {
		Long returnLong = new Long(-1);

		try {
			returnLong = ((Integer) row.get(columnName)).longValue();
		} catch (NullPointerException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return returnLong;
	}

	public double getDouble(ResultSet rs, String columnName) {
		double returnDouble = 0;

		try {
			returnDouble = rs.getDouble(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return returnDouble;
	}

	public double getDouble(Map<String, Object> row, String columnName) {
		double returnDouble = 0;
		try {
			returnDouble = ((Float) row.get(columnName)).floatValue();
		} catch (NullPointerException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}
		return returnDouble;
	}

	public BigDecimal getBidDecimal(Map<String, Object> row, String columnName) {
		BigDecimal bigToReturn = new BigDecimal(-1);

		bigToReturn = (BigDecimal) row.get(columnName);

		return bigToReturn;
	}

	public BigDecimal getBidDecimal(ResultSet rs, String columnName) {
		BigDecimal bigToReturn = new BigDecimal(-1);

		try {
			bigToReturn = (BigDecimal) rs.getBigDecimal(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return bigToReturn;
	}
}

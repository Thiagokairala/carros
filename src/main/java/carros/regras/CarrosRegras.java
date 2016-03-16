package carros.regras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

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

	public int getInt(ResultSet rs, String columnName) {
		int returnInt = -1;

		try {
			returnInt = rs.getInt(columnName);
		} catch (SQLException e) {
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

	public Boolean getBoolean(ResultSet rs, String columnName) {
		Boolean bool = false;
		try {
			bool = rs.getBoolean(columnName);
		} catch (SQLException e) {
			logger.warn("Field " + columnName + " not in the resultSet");
		}

		return bool;
	}

	public Long getLong(ResultSet rs, String columnName) {
		Long returnLong = new Long(0);

		try {
			returnLong = rs.getLong(columnName);
		} catch (SQLException e) {
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
}

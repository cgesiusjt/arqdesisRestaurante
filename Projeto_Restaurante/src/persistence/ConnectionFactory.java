package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("con.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e); 
		}
	}

	public static Connection openConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante?user=root&password=brqbrq");
	}

}

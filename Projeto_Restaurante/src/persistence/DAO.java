package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/restaurante";
	private static final String USER = "root";
	private static final String PASSWORD = "brqbrq";
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	protected void openConection() throws Exception {

		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	protected void closeConection() throws Exception {

		if (con != null) {

			con.close();
		}
	}

}

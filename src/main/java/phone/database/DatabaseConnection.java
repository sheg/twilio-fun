package phone.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private static Connection _conn = null;

	private Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
		if (_conn != null) {
			return _conn;
		}
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String url = "*";
		String databaseName = "*";
		String username = "*";
		String password = "*";

		String connectionUrl = "jdbc:sqlserver://" + url + ";databaseName=" + databaseName +";user=" + username +";password=" + password + ";";
		if(_conn == null) {
			_conn = DriverManager.getConnection(connectionUrl);
		}
		return _conn;
	}

	public ResultSet executeQuery(String query) throws Exception {
		ResultSet resultSet = null;
		
		Connection conn = getDatabaseConnection();
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(query);

		return resultSet;
	}
}
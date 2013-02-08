package phone.database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class DatabaseConnection {

	private static Connection _conn = null;

	private Connection getDatabaseConnection() throws SQLException, ClassNotFoundException, JsonIOException, JsonSyntaxException, FileNotFoundException {
		if (_conn != null) {
			return _conn;
		}
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setDatabaseAttributes("/opt/work/twilio/twilio/src/main/java/phone/configs/database.json");
		Map<String, String> dbAttributes = dbConfig.getDatabaseAttribures();
		
		String url = dbAttributes.get("serverUrl");
		String databaseName = dbAttributes.get("databaseName");
		String username = dbAttributes.get("username");
		String password = dbAttributes.get("password");

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
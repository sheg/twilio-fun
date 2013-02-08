package callers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import phone.database.DatabaseConnection;

public class PhoneNumbers {

	private List<String> listenerNumbers = new ArrayList<String>();
	private List<String> guestNumbers = new ArrayList<String>();
	private DatabaseConnection db = new DatabaseConnection();

	private final static String LISTENER_QUERY = "SELECT number FROM psprd1.pcsprod.access_lines (NOLOCK) WHERE listener_type = 'P'";
	private final static String GUEST_QUERY = "SELECT number FROM psprd1.pcsprod.access_lines (NOLOCK) WHERE listener_type = 'G'";

	public void setListenerNumbers() throws Exception {
		ResultSet results = db.executeQuery(LISTENER_QUERY);
		while (results.next()) {
			listenerNumbers.add(results.getString("number"));
		}
	}

	public void setGuestNumbers() throws Exception {
		ResultSet results = db.executeQuery(GUEST_QUERY);
		while (results.next()) {
			guestNumbers.add(results.getString("number"));
		}
	}

	public List<String> getListenerNumbers() {
		return listenerNumbers;
	}
	
	public List<String> getGuestNumbers() {
		return guestNumbers;
	}
}
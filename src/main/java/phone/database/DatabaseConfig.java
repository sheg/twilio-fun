package phone.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class DatabaseConfig {
	
	private Map<String,String> databaseAttributes = new HashMap<String,String>();
	
	public Map<String,String> getDatabaseAttribures() {
		return this.databaseAttributes;
	}
	
	public void setDatabaseAttributes(String configFilePath) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = null;
        JsonObject jsonObject = null;
        
        jsonElement = parser.parse(new FileReader(configFilePath));
        jsonObject = jsonElement.getAsJsonObject();
        
		this.databaseAttributes = gson.fromJson(jsonObject.get("databaseAttributes"), new TypeToken<HashMap<String, String>>(){}.getType());
	}
}

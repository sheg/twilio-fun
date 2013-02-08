package sandbox;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;


/**
 * This is a main class
 * @author danielforkosh
 *
 */
public class MakeCall {
	
	public static final String ACCOUNT_SID = "AC780be3afe03c2d1f6688601b858b28a2";
	public static final String AUTH_TOKEN = "06c6831829439d93c7a0745ba84ae616";
	
	public static void main(String [] args) throws Exception {
		
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		Account mainAccount = client.getAccount();
		CallFactory callFactory = mainAccount.getCallFactory();
		
		Map<String, String> callParams = new HashMap<String, String>();
		callParams.put("To", "9175107857");
		callParams.put("From", "(347) 696-4837");
		callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
		callParams.put("SendDigits", "6545666555666654566655654");
		
		Call call = callFactory.create(callParams);
		
		
		System.out.println(call.getSid());
	}
}

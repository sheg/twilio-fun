package phone;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

/**
 * This class makes a call out using Twilio API
 * @author danielforkosh
 *
 */
public class CallManager {
	
	private CallFactory _callFactory = null;
	private Account _mainAccount;
	private Call _call = null;

	
	public CallManager(String accountSID, String authToken) {
		TwilioRestClient client = new TwilioRestClient(accountSID, authToken);
		this._mainAccount = client.getAccount();
		_callFactory = _mainAccount.getCallFactory();
	}

	public void makeCallOut(Map<String,String> callParams) throws TwilioRestException {
		_call = _callFactory.create(callParams);
	
	}

	public void makeCallOut(String to, String from) throws TwilioRestException {		
		Map<String, String> callParams = new HashMap<String, String>();
		callParams.put("To", to);
		callParams.put("From", from);
		callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
		_call = _callFactory.create(callParams);
	}

	public void makeCallOut(String to) throws TwilioRestException {
		Map<String, String> callParams = new HashMap<String, String>();
		callParams.put("To", to);
		callParams.put("From", _mainAccount.getProperty("phone"));
		callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
		_call = _callFactory.create(callParams);
	}	
	
	public Call getCall() {
		return _call;
	}
}
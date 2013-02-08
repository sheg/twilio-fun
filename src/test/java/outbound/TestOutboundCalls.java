package outbound;


import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import phone.CallManager;
import callers.PhoneNumbers;

import com.twilio.sdk.TwilioRestException;

public class TestOutboundCalls {
	
	CallManager callManager = null;
	PhoneNumbers numbers = null;
	
	@Before
	public void setUp() throws Exception {
		callManager = new CallManager("AC780be3afe03c2d1f6688601b858b28a2","06c6831829439d93c7a0745ba84ae616");
		numbers = new PhoneNumbers();
		numbers.setGuestNumbers();
		numbers.setListenerNumbers();
	}

	@Test
	public void testSingleOutboudCall() throws TwilioRestException {
		Map<String, String> callParams = new HashMap<String, String>();
		callParams.put("To", "19175107857");
		callParams.put("From", "(347) 696-4837");
		callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
		callParams.put("StatusCallback", "http://mp3.erobbins.com/twilio/index.php");
		callManager.makeCallOut(callParams);
		System.out.println(callManager.getCall().getStatus());
	}
	
	@Test
	public void testGuestNumberResults() throws Exception {
		System.out.println(numbers.getGuestNumbers().get(0));
	}
	
	@Test
	public void testListenerNumberResults() throws Exception {
		System.out.println(numbers.getListenerNumbers().get(0));
	}
	
	@After
	public void tearDown() throws Exception {}
}
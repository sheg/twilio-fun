package outbound;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import phone.CallManager;
import callers.PhoneNumbers;

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

//	@Test
//	public void testSingleOutboudCall() throws TwilioRestException {
//		callManager.makeCallOut("19175107857", "(347) 696-4837");
//		assertTrue(callManager.getCall().getStatus() != null);
//	}
	
	@Test
	public void testGuestNumberResults() throws Exception {
		System.out.println(numbers.getGuestNumbers().get(0));
	}
	
	@After
	public void tearDown() throws Exception {}
}
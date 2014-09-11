import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class TestAddUser {
	
	String serverAddress = "http://129.241.126.66/cgi-bin/adduser.py";
	
	
	
	@Test
	public void CheckAddNormalUser() {
		ArrayList<String> parameters = new ArrayList<String>();
		ArrayList<String> keys = new ArrayList<String>();
		
		keys.add("username");
		parameters.add("test");
		
		keys.add("password");
		parameters.add("testpassword");
		
		keys.add("email");
		parameters.add("testmail@gmail.com");
		
		keys.add("tlf");
		parameters.add("91039293");
		
		keys.add("name");
		parameters.add("Test Testesen");
		
		String status = dbClass.SendRequest(parameters, keys, serverAddress);
		System.out.println(status);
		assertEquals(status, "OK");
		status = dbClass.SendRequest(parameters, keys, serverAddress);
		assertEquals(status, "unused");
	}
}

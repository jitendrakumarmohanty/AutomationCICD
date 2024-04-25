
package prameterexamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterXML {
	
	@Parameters({"userid","password"})
	@Test
	public void doLogin(String uid,String pwd) {
		
		System.out.println("userID:>>>>>>"+uid+"Pwd :>>>>>>>>>"+pwd);
		
	}

}

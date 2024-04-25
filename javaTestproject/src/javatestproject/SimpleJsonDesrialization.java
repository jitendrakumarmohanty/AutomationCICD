package javatestproject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class SimpleJsonDesrialization {

	@Test
	public void desJson() throws ParseException {
		
	String str="{\r\n"
			+ "  \"website\": \"https://www.google.com\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park1\",\r\n"
			+ "    \"shoe park2\"\r\n"
			+ "  ],\r\n"
			+ "  \"address\": {\r\n"
			+ "    \"road\": \"MG Road Cross cut Street\",\r\n"
			+ "    \"city\": \"Bangalore\",\r\n"
			+ "    \"state\": \"Karnataka\",\r\n"
			+ "    \"pinCode\": \"560064\"\r\n"
			+ "  },\r\n"
			+ "  \"phoneNos\": [\r\n"
			+ "    {\r\n"
			+ "      \"presentAt\": \"home\",\r\n"
			+ "      \"phoneNumber\": \"1234567890\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"type2\": \"fax1\",\r\n"
			+ "      \"no1\": \"6366182095\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"accuracy\": 909011,\r\n"
			+ "  \"language\": \"French-FN\"\r\n"
			+ "}";	
	
	System.out.println(str);
	
	  JSONParser jp=new JSONParser();
	  JSONObject jo=(JSONObject) jp.parse(str);
	  
	  System.out.println((String)jo.get("language"));
	  
	  JSONObject jobjadd = (JSONObject)jo.get("address");
	  System.out.println((String)jobjadd.get("road"));
	  
		
	}
	
}

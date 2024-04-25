package javatestproject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SimpleJSONSerialization {
	
	@Test
	void SerializeUsingSimpleJson() {
	
	JSONObject jo=new JSONObject();
	jo.put("accuracy", 909011);
	jo.put("website", "https://www.google.com");
	jo.put("language", "French-FN");
	
	JSONArray type=new JSONArray();
	
	type.add("shoe park1");
	type.add("shoe park2");
	jo.put("types", type);
	
	// LinkedHashMap is created for address data 
    Map<String,String> addressMap = new LinkedHashMap<String,String>(4); 
    addressMap.put("road", "MG Road Cross cut Street"); 
    addressMap.put("city", "Bangalore"); 
    addressMap.put("state", "Karnataka"); 
    addressMap.put("pinCode", "560064"); 
	
	jo.put("address", addressMap);
	
    // JSONArray is created to add the phone numbers 
    JSONArray phoneNumberJsonArray = new JSONArray(); 
    addressMap = new LinkedHashMap(2); 
    addressMap.put("presentAt", "home"); 
    addressMap.put("phoneNumber", "1234567890"); 

    // adding map to list 
    phoneNumberJsonArray.add(addressMap); 
    addressMap = new LinkedHashMap(2); 
    addressMap.put("type2", "fax1"); 
    addressMap.put("no1", "6366182095"); 

    // map is added to the list 
    phoneNumberJsonArray.add(addressMap); 

    // adding phone numbers to the created JSON object 
    jo.put("phoneNos", phoneNumberJsonArray); 
	
	
	
	System.out.println(jo.toJSONString());
	}

}

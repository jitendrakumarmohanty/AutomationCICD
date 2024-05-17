package javatestproject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;


//body json test

public class APIBodyJACKSON {
	
	@Test
	public void serializeAddPlaceBody() throws ParseException, JsonProcessingException {
		
		  AddLocationPojo al = new AddLocationPojo();
		  al.setAccuracy(909110);
		  al.setAddress("0909, side layout, cohen 09000");
		  al.setLanguage("French-FN");
		  al.setWebsite("http://google.com");
		  al.setPhone_number("(+91) 983 893 3995");
		  al.setName("Frontline 66house");
		  List<String> typs=new ArrayList<String>();
		  typs.add("shoe park1");
		  typs.add("New rack1");
		  al.setTypes(typs);
		  LocationDetails ld=new LocationDetails();
		  ld.setLat(-38.383433);
		  ld.setLng(33.427364);
		  al.setLocation(ld);
		  
		  ObjectMapper om=new ObjectMapper();
		  om.writeValueAsString(al);
		  
		
		 RestAssured.baseURI="https://rahulshettyacademy.com/";
		 
		 
		 String res=given().log().all()
		.queryParam("key","qaclick123")
		.body(al)
		.when()
		.post("/maps/api/place/add/json")
		.then().extract().asString();
		 
		System.out.println(res);
		System.out.println(al.toString());

		 
		JSONParser jp = new JSONParser();		
		Object jo =jp.parse(res);
		JSONObject jb=(JSONObject)jo;
		System.out.println((String)jb.get("status")+"Hello");
		
		Assert.assertEquals((String)jb.get("status"), "OK");
		
	}
}

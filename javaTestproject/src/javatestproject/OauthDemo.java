package javatestproject;


import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class OauthDemo {
	
	@Test
	public void getOAuthExample() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		 String responseToken = given().log().all()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when()
		.post("/oauthapi/oauth2/resourceOwner/token")
		.then()
		.extract().asString();
		
		  //System.out.println(responseToken);

		//();
		
		JsonPath js=new JsonPath(responseToken);
		
		String exp_access_token=js.getString("access_token");
		
		 GetCourse gc = given()
		.queryParam("access_token",exp_access_token)
		.when()
		.get("oauthapi/getCourseDetails").as(GetCourse.class);
		  Courses cc = gc.getCourses();
		  
		  List<Api> apiList = gc.getCourses().getApi(); int bPrice=0; String
		  expSub="Rest Assured Automation using Java"; int expBPrice=50;
		  System.out.println(apiList.size()); for(int i=0 ;i<apiList.size(); i++) { if
		  (apiList.get(i).getCourseTitle().equalsIgnoreCase(expSub)) { bPrice =
		  apiList.get(i).getPrice(); } }
		  
		  System.out.println(bPrice);
		  
		  Assert.assertEquals(bPrice, expBPrice);
				 
	}
    	
}

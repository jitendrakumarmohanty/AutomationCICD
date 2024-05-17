package javatestproject;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//address updated   ;
public class AddAddressJackson {
	
	@Test
	public void AddAddress() throws JsonProcessingException {

	AddAddressPOJO add=new AddAddressPOJO();
	add.setAccuracy("909011909011");
	Address adr=new Address();
	adr.setCity("Newark");
	adr.setPinCode("10001-0091");
	adr.setRoad("Akbar road");
	adr.setState("CA");
	
	add.setAddress(adr);
	add.setLanguage("English-EN");
	
	List<Phones> lphs =new ArrayList<Phones>();
	
	Phones ph=new Phones();
	ph.setPhoneNumber("989-098-7650");
	ph.setPresentAt("pxxx");
	
	lphs.add(ph);
	Phones ph1=new Phones();
	ph1.setPhoneNumber("999-000-0001");
	ph1.setPresentAt("YYYYxx");
	lphs.add(ph1);
	add.setPhones(lphs);
	
	List<String> ltyps=new ArrayList<String>();
	ltyps.add("Set Types");
	ltyps.add("Pet types");
	
	add.setTypes(ltyps);
	add.setWebsite("https://www.yahoo.co.in");
	
	ObjectMapper mapper = new ObjectMapper();  
    String addStr= mapper.writeValueAsString(add);
	
	System.out.println(addStr);
	
	}
}

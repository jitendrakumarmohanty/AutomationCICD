package prameterexamples;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

	@Parameters({"browser"})
	@Test
	public void doLogin(String b) throws InterruptedException {
		
		Date d=new Date();
		System.out.println(b+":::::Login Running parallely"+d);
		Thread.sleep(2000);
	}
	
	/*
	@Parameter({"browser"})
	@Test
	public void doReg(String bb) {
		Date d=new Date();
		System.out.println(bb+"<<<<<<<<<<<Reg Running parallely "+d.getTime());
	}
	*/
	
	
}

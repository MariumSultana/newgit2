package TestCases;

import org.junit.Ignore;
import org.junit.Test;

public class FirstTestCase {

	
		
	@Test //test case 
	public void loginTest(){
		System.out.println("Testing on login");
	}
	@Ignore
	@Test
	public void registerTest(){
		System.out.println("Register user");
	}
	@Test
	public void databaseTest(){
		System.out.println("Testing the database");
	}
}

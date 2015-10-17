package testSuite08_01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondWNR {
	@BeforeClass
	public static void begin(){
		System.out.println("2nd beforeclass start execution");
	}

	@Before
	public void start1(){
		System.out.println("2nd class start execution");
	}
	@Test
	public void TestLogin(){
		System.out.println("login process");
	}
	
	@After
	public void end1(){
		System.out.println("2nd class end execution");
	}
	@AfterClass
	public static void finish(){
		
	}
}

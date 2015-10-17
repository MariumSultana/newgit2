package TestCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondTestCase {
	
	public static boolean checkLogin(){
		return true;
	}
	@BeforeClass
	public static void begining(){
		System.out.println("**************Begining*******************");
		Assume.assumeTrue(checkLogin());
	}
@Before
public void openBrowser(){
	//code using selenium
	System.out.println("Opening the browser");
}

	@Test
	public void sendEmailTest(){
		System.out.println("send the email");
	}
	@Test
	public void sendMessTest(){
		System.out.println("send the text message");
	}
	@After
	public void closeBrowser(){
		//code using selenium
		System.out.println("Closing teh browser");
	}
	@AfterClass
	public static void ending(){
		System.out.println("**************Ending*******************");
	}
}

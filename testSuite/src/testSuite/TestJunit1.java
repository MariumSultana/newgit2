package testSuite;


import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestJunit1 {
	@BeforeClass
	public static void start(){
		System.out.println("******start1******");
		}
	@Test
	public void testPrintMessage(){
		System.out.println("the message displayed");
		
		
	}
	
	@AfterClass
	public static void end(){
		System.out.println("******end1******");
	}
}

package fixtureProject;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class JavaTest extends TestCase {
	
protected int num1, num2;

protected void setUp(){
	num1 = 3;
	num2 = 6;
}
public void testAdd(){
	double result = num1+num2;
	try{
 assertTrue(result!=9);
	} catch(AssertionFailedError ee){
		System.out.println("need to fix");
	} finally{
		assertTrue(result==9);
		System.out.println(" fixed");
	}
		
	
	}
	
}





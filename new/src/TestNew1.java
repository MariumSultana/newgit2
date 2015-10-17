import junit.framework.*;
public class TestNew1 extends Course {

 protected int a1, a2;
 
 protected void setUp(){
	 a1=3;
	 a2=3;
 }
	
	 public void testAdd(){
		 double result = a1+a2;
		 assertTrue(result == 6);
	 }

	
	
		
 
	
	
}
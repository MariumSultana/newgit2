package testSuite08_01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FirstWR {
	
	String message = "Robarts";
	MessageUtil mUtil = new MessageUtil(message);
@Before
public void start1(){
	System.out.println("first class start execution");
}

@Test
public void TestWR(){
	int min;
int 	a = 1;
	int b = 6;
	if(a<b)
		min=a;
	else
		min=b;
		
	System.out.println(min);
	
}
@Test
public void TestSalute(){
	System.out.println("inside salute");
	//message = "hi" + "robart";	
	Assert.assertEquals(message, mUtil.Salute());
}
@After
public void end1(){
	System.out.println("first class end execution");
}
	
	
	
	
}

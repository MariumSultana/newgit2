package testSuite08_01;

import java.util.Arrays;
import java.util.Collection;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizationT {
	
	String name;
	String pass;
	int pin;
	public ParameterizationT(String name, String pass, int pin){
		this.name = name;
		this.pass = pass;
		this.pin = pin;
	}
	@Parameters
	public static Collection<Object[]> getData(){
		Object o[][] = new Object[2][3];
		
		o[0][0]="test1";
		o[0][1]="pass1";
		o[0][2]= 9000;
		
		o[1][0]="test1";
		o[1][1]="pass1";
		o[1][2]= 9000;
		
		
		
		return Arrays.asList(o);
		
			
}
	
	
	@Before
	public void start1(){
		System.out.println("ParameterizationT class start execution");
	}
	@Test
	public void TestCheckin(){
		System.out.println("checkin"+name+" "+pass+" "+pin+" ");
	}
	@After
	public void end1(){
		System.out.println("ParameterizationT class end execution");
	}
}

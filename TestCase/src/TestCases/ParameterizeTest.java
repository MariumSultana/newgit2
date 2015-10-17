package TestCases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//step 1
@RunWith(Parameterized.class)

public class ParameterizeTest {
	//step 2
	public String username;
	public String password;
	public int pin;
	//step3
	public ParameterizeTest(String username, String password, int pin){
		this.username=username;//globle pramither to local parameter
		this.password=password;
		this.pin=pin;
		}
		//step 4
		@Parameters
		public static  Collection<Object[]> data(){
			//rows- number of times you want to repeat test
			//column- number of parameters you want to pass
			Object[][] data= new Object[2][3];
			data[0][0]="testuser1";
			data[0][1]="Pass1";
			data[0][2]=365;
			//2nd set row
			
			data[1][0]="testuser2";
			data[1][1]="Pass2";
			data[1][2]=36536;
			return Arrays.asList(data);
			
		}
		
	
	
	
	
	@Test
	public void retisterTest(){
		System.out.println("testing registration--"+username+"--"+password+"---"+pin);
		
	}

}

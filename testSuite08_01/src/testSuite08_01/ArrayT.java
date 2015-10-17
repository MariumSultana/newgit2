package testSuite08_01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ArrayT {
	@Rule
public	ErrorCollector e = new ErrorCollector();
	@Before
	public void start1(){
		System.out.println("Array class start execution");
	}
	@Test
	public void TestTC(){
		int a = 5;
		int ex = 6;
		try{
			Assert.assertEquals(ex, a);
		}catch(Throwable t){
			e.addError(t);
		}finally{
			System.out.println("the case is pass");
		}
	}
	@After
	public void end1(){
		System.out.println("Array class end execution");
	}
}

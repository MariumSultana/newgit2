import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class First{
	
	@Rule
	public ErrorCollector e = new ErrorCollector();
	
	@Before
	public void start(){
		System.out.println("start");
	}
	@Test
	public void login(){
		int a = 2;
		int ex = 3;
		try{
		Assert.assertEquals(ex, a);
		}catch(Throwable t){
			e.addError(t);
			System.out.println("e.addError(t)");
		}finally{
			System.out.println("final");
		}
	}
	@After
	public void end(){
		System.out.println("end");
	}
}
















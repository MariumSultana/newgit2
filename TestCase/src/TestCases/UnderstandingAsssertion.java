 package TestCases;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class UnderstandingAsssertion {
	@Rule
	public ErrorCollector errCollector = new ErrorCollector();
@Test
public void testFriendlist(){
	int actule_t_friends=100;
	int expected_t_friends=110;
	/*if(actule_t_friends==expected_t_friends){
	System.out. println("pass");
	}else{
		System.out.println("fail");
	}*/
	System.out.println("A");
	try{
	Assert.assertEquals(expected_t_friends,actule_t_friends);
	}catch(Throwable t){
		System.out.println("the assartion error skipped");
		errCollector.addError(t);
	}
	System.out.println("B");
	
	try{
		Assert.assertEquals("A","B");
		}catch(Throwable t){
			System.out.println("the assartion error skipped");
			errCollector.addError(t);
		}
	try{
		Assert.assertEquals("A","A");
		}catch(Throwable t){
			System.out.println("the assartion error skipped");
			errCollector.addError(t);
		}
}


}

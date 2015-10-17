import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest
{
	//junit is a testing fraemwork
	//basically we are working under a framework
	//its used for unit testing
	//its a fraemwork for java
	//before is a annotation, you use this because you have some common functionality that goes under before annotations
	//after annotations is used because you have to quit the browser
	//and test annotation is a replacement of main method.
	
	
	FirefoxDriver dr= new FirefoxDriver(); //this opens up a firefox browser because of the constructor itself.
	@Before
	public void start()
	{
			dr.get("http://www.google.com");
			
		
		
	}
	
	@After
	public void end()
	{
		
		
		dr.quit();
		
		
		
	}
	
	
	
	
	
	
	
}
